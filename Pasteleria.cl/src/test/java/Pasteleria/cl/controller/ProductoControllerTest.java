package Pasteleria.cl.controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import Pasteleria.cl.model.Producto;
import Pasteleria.cl.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductoControllerTest {

    @Mock
    private ProductoRepository repository;

    @InjectMocks
    private ProductoController controller;

    // PRUEBA 1: Listar todos los productos (Catálogo)
    @Test
    public void alObtenerTodos_DeberiaRetornarListaCompleta() {
        // ARRANGE
        Producto p1 = new Producto(); p1.setNombre("Torta 1");
        Producto p2 = new Producto(); p2.setNombre("Torta 2");
        
        when(repository.findAll()).thenReturn(Arrays.asList(p1, p2));

        // ACT
        List<Producto> resultado = controller.obtenerTodos();

        // ASSERT
        assertEquals(2, resultado.size(), "Debería traer 2 productos");
    }

    // PRUEBA 2: Filtrar por Categoría (Funcionalidad clave del cliente)
    @Test
    public void alFiltrarPorCategoria_DeberiaLlamarAlRepositorio() {
        // ARRANGE
        Producto vegano = new Producto();
        vegano.setCategoria("Vegano");
        
        when(repository.findByCategoria("Vegano")).thenReturn(Arrays.asList(vegano));

        // ACT
        List<Producto> resultado = controller.filtrarPorCategoria("Vegano");

        // ASSERT
        assertEquals(1, resultado.size());
        assertEquals("Vegano", resultado.get(0).getCategoria());
    }

    // PRUEBA 3: Crear Producto (Funcionalidad de Admin)
    @Test
    public void alCrearProducto_DeberiaGuardarlo() {
        // ARRANGE
        Producto nuevo = new Producto();
        nuevo.setCodigo("TEST01");
        nuevo.setNombre("Torta Test");
        
        when(repository.save(any(Producto.class))).thenReturn(nuevo);

        // ACT
        Producto resultado = controller.crearProducto(nuevo);

        // ASSERT
        assertNotNull(resultado);
        assertEquals("TEST01", resultado.getCodigo());
    }

    // PRUEBA 4: Eliminar Producto (Funcionalidad de Admin)
    @Test
    public void alEliminarProducto_DeberiaBorrarPorId() {
        // ARRANGE
        Long idBorrar = 1L;
        // deleteById no retorna nada (void), así que no usamos 'when'

        // ACT
        controller.eliminarProducto(idBorrar);

        // ASSERT
        // Verificamos que el método deleteById del repositorio fue llamado 1 vez con el ID 1
        verify(repository, times(1)).deleteById(idBorrar);
    }
}