package Pasteleria.cl.repository;

import Pasteleria.cl.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
    // ¡Magia! Solo con escribir esto, Spring ya sabe cómo hacer el SELECT por categoría
    // SELECT * FROM productos WHERE categoria = ?
    List<Producto> findByCategoria(String categoria);
}