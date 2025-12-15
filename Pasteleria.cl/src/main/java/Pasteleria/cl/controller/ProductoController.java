package Pasteleria.cl.controller;

import Pasteleria.cl.model.Producto;
import Pasteleria.cl.repository.ProductoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    private final ProductoRepository repository;

    public ProductoController(ProductoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Producto> obtenerTodos() {
        return repository.findAll();
    }

    // Filtrar (ya lo tenías)
    @GetMapping("/filtrar")
    public List<Producto> filtrarPorCategoria(@RequestParam String categoria) {
        return repository.findByCategoria(categoria);
    }

    // --- NUEVO: CREAR PRODUCTO ---
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return repository.save(producto);
    }

    // --- NUEVO: EDITAR PRODUCTO ---
    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto productoActualizado) {
        return repository.findById(id)
            .map(producto -> {
                producto.setNombre(productoActualizado.getNombre());
                producto.setPrecio(productoActualizado.getPrecio());
                producto.setCategoria(productoActualizado.getCategoria());
                producto.setCodigo(productoActualizado.getCodigo());
                producto.setDescripcion(productoActualizado.getDescripcion());
                producto.setImagenUrl(productoActualizado.getImagenUrl());
                return repository.save(producto);
            })
            .orElse(null);
    }

    // --- NUEVO: ELIMINAR PRODUCTO ---
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        repository.deleteById(id);
    }
}