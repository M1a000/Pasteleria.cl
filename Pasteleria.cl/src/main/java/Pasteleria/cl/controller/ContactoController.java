package Pasteleria.cl.controller;

import Pasteleria.cl.model.Contacto;
import Pasteleria.cl.repository.ContactoRepository;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/contactos")
@CrossOrigin(origins = "*")
public class ContactoController {

    private final ContactoRepository repository;

    public ContactoController(ContactoRepository repository) {
        this.repository = repository;
    }

    // Endpoint para RECIBIR el mensaje
    @PostMapping
    public Contacto enviarMensaje(@RequestBody Contacto contacto) {
        contacto.setFecha(LocalDateTime.now()); // Le ponemos la fecha actual automática
        return repository.save(contacto);
    }
}