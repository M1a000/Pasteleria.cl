package Pasteleria.cl.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import Pasteleria.cl.model.Usuario;
import Pasteleria.cl.repository.UsuarioRepository;
import Pasteleria.cl.service.JwtService; // <--- IMPORTANTE: Importar el servicio
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map; // <--- IMPORTANTE: Para leer la respuesta del login
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UsuarioControllerTest {

    @Mock
    private UsuarioRepository repository;

    @Mock // <--- NUEVO: Mockeamos el servicio de JWT porque el controlador lo usa
    private JwtService jwtService;

    @InjectMocks
    private UsuarioController controller;

    // PRUEBA 1: Login Exitoso con JWT
    @Test
    public void alHacerLogin_ConCredencialesCorrectas_RetornaUsuarioYToken() {
        // 1. ARRANGE (Preparar datos)
        Usuario usuarioReal = new Usuario();
        usuarioReal.setId(1L);
        usuarioReal.setEmail("test@duoc.cl");
        usuarioReal.setPassword("123456");
        usuarioReal.setNombre("Juan Test");
        usuarioReal.setRol("CLIENTE");

        Usuario credenciales = new Usuario();
        credenciales.setEmail("test@duoc.cl");
        credenciales.setPassword("123456");

        // Simulamos que la BD encuentra al usuario
        when(repository.findByEmail("test@duoc.cl")).thenReturn(Optional.of(usuarioReal));
        
        // Simulamos que el generador de tokens devuelve un texto falso
        when(jwtService.generarToken(anyLong(), anyString(), anyString())).thenReturn("token-falso-123");

        // 2. ACT (Ejecutar)
        // Ahora el login devuelve un MAP, no un Usuario directo
        Map<String, Object> resultado = controller.login(credenciales);

        // 3. ASSERT (Verificar)
        assertNotNull(resultado, "El resultado no debe ser null");
        assertTrue(resultado.containsKey("token"), "La respuesta debe tener un token");
        assertTrue(resultado.containsKey("usuario"), "La respuesta debe tener los datos del usuario");
        
        assertEquals("token-falso-123", resultado.get("token"));
        
        // Verificamos que el usuario dentro del mapa sea correcto
        Usuario usuarioDevuelto = (Usuario) resultado.get("usuario");
        assertEquals("Juan Test", usuarioDevuelto.getNombre());
    }

    // PRUEBA 2: Login Fallido
    @Test
    public void alHacerLogin_ConPasswordIncorrecta_RetornaNull() {
        // 1. ARRANGE
        Usuario usuarioEnBD = new Usuario();
        usuarioEnBD.setEmail("test@duoc.cl");
        usuarioEnBD.setPassword("123456");

        Usuario credencialesIncorrectas = new Usuario();
        credencialesIncorrectas.setEmail("test@duoc.cl");
        credencialesIncorrectas.setPassword("malacontrasena");

        when(repository.findByEmail("test@duoc.cl")).thenReturn(Optional.of(usuarioEnBD));

        // 2. ACT
        Map<String, Object> resultado = controller.login(credencialesIncorrectas);

        // 3. ASSERT
        assertNull(resultado, "Debe retornar null si la contraseña falla");
    }

    // PRUEBA 3: Registro (Este casi no cambia)
    @Test
    public void alRegistrarUsuario_DeberiaGuardarEnBaseDeDatos() {
        // 1. ARRANGE
        Usuario nuevo = new Usuario();
        nuevo.setEmail("nuevo@duoc.cl");
        nuevo.setRol("CLIENTE");

        when(repository.save(any(Usuario.class))).thenReturn(nuevo);

        // 2. ACT
        Usuario resultado = controller.registrarUsuario(nuevo);

        // 3. ASSERT
        assertNotNull(resultado);
        verify(repository, times(1)).save(nuevo);
    }
}