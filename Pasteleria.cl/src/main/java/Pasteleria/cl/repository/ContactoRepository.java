package Pasteleria.cl.repository;

import Pasteleria.cl.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {
    // Listo, ya podemos guardar mensajes
}