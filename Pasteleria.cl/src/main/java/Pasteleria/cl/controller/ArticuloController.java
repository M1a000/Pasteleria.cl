package Pasteleria.cl.controller;

import Pasteleria.cl.model.Articulo;
import Pasteleria.cl.repository.ArticuloRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/articulos")
@CrossOrigin(origins = "*")
public class ArticuloController {

    private final ArticuloRepository repository;

    public ArticuloController(ArticuloRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Articulo> obtenerNoticias() {
        return repository.findAll();
    }
    
    @PostMapping
    public Articulo crearNoticia(@RequestBody Articulo articulo) {
        return repository.save(articulo);
    }
}