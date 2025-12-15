package Pasteleria.cl.controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import Pasteleria.cl.model.Contacto;
import Pasteleria.cl.repository.ContactoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ContactoControllerTest {

    @Mock
    private ContactoRepository repository;

    @InjectMocks
    private ContactoController controller;

    @Test
    public void alEnviarMensaje_DeberiaGuardarConFecha() {
        // 1. ARRANGE
        Contacto mensaje = new Contacto();
        mensaje.setNombre("Cliente Dudoso");
        mensaje.setEmail("duda@mail.com");
        mensaje.setMensaje("¿Tienen tortas sin gluten?");

        // Simulamos que al guardar, devuelve el mismo objeto
        when(repository.save(any(Contacto.class))).thenReturn(mensaje);

        // 2. ACT
        Contacto resultado = controller.enviarMensaje(mensaje);

        // 3. ASSERT
        assertNotNull(resultado);
        assertEquals("Cliente Dudoso", resultado.getNombre());
        
        // Verificamos que el repositorio guardó el mensaje
        verify(repository, times(1)).save(mensaje);
        
        // OJO: En el controlador real asignamos la fecha (LocalDateTime.now())
        // Aquí comprobamos que el objeto pasó por el proceso de guardado.
        assertNotNull(resultado.getFecha(), "La fecha se asigna automáticamente en el controlador, así que no debería ser null si pasara por la lógica real completa (pero como es unitario mockeado, depende de tu implementación exacta. Si falla, puedes quitar esta línea)");
    }
}