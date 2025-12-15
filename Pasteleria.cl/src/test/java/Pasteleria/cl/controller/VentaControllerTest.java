package Pasteleria.cl.controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import Pasteleria.cl.model.Venta;
import Pasteleria.cl.repository.VentaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

// @ExtendWith: Le dice a JUnit que use Mockito para simular la base de datos
@ExtendWith(MockitoExtension.class)
public class VentaControllerTest {

    // @Mock: Creamos un repositorio "FALSO". No conectará a MySQL real.
    @Mock
    private VentaRepository repository;

    // @InjectMocks: Inyectamos el repositorio falso dentro del controlador real.
    @InjectMocks
    private VentaController controller;

    // PRUEBA 1: Verificar que se puede guardar una venta
    @Test
    public void alCrearVenta_DeberiaGuardarYRetornarVenta() {
        // 1. ARRANGE (Preparar datos de prueba)
        Venta ventaNueva = new Venta();
        ventaNueva.setNombreUsuario("Tester");
        ventaNueva.setTotalPagado(25000.0);

        // Le enseñamos al mock: "Cuando te pidan guardar cualquier venta, devuelve esa misma venta"
        when(repository.save(any(Venta.class))).thenReturn(ventaNueva);

        // 2. ACT (Ejecutar el método del controlador)
        Venta resultado = controller.crearVenta(ventaNueva);

        // 3. ASSERT (Verificar que pasó lo esperado)
        assertNotNull(resultado); // No debe ser null
        assertEquals(25000.0, resultado.getTotalPagado()); // El monto debe coincidir
        assertEquals("Tester", resultado.getNombreUsuario()); // El nombre debe coincidir
        
        // Verificamos que el repositorio falso fue llamado exactamente 1 vez
        verify(repository, times(1)).save(ventaNueva);
    }

    // PRUEBA 2: Verificar que el historial trae datos
    @Test
    public void alObtenerVentas_DeberiaRetornarLista() {
        // 1. ARRANGE
        Venta v1 = new Venta();
        Venta v2 = new Venta();
        // Simulamos que la base de datos devuelve una lista con 2 ventas
        when(repository.findAll()).thenReturn(Arrays.asList(v1, v2));

        // 2. ACT
        List<Venta> lista = controller.obtenerTodasLasVentas();

        // 3. ASSERT
        assertNotNull(lista);
        assertEquals(2, lista.size()); // Deben haber 2 elementos
    }
}