package Pasteleria.cl.controller;

import Pasteleria.cl.model.Venta;
import Pasteleria.cl.repository.VentaRepository;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = "*")
public class VentaController {

    private final VentaRepository repository;

    public VentaController(VentaRepository repository) {
        this.repository = repository;
    }

    // Guardar una venta nueva
@PostMapping
    public Venta crearVenta(@RequestBody Venta venta) {
        venta.setFecha(LocalDateTime.now()); // Fecha de compra (hoy)
        
        // Estado inicial automático
        venta.setEstado("En Preparación"); 
        
        return repository.save(venta);
    }

    // Ver historial (Opcional, por si lo piden)
    @GetMapping("/usuario/{id}")
    public List<Venta> obtenerPorUsuario(@PathVariable Long id) {
        return repository.findByUsuarioId(id);
    }

    // Endpoint para que el VENDEDOR/ADMIN vea TODAS las ventas
    // GET http://localhost:8080/api/ventas
    @GetMapping
    public List<Venta> obtenerTodasLasVentas() {
        return repository.findAll(); // Devuelve todo el historial de la tienda
    }
}