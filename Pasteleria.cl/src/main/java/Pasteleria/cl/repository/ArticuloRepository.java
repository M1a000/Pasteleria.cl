package Pasteleria.cl.repository;

import Pasteleria.cl.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
    // No necesitamos nada especial, con los métodos básicos basta
}