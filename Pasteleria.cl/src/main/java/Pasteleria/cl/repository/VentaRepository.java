package Pasteleria.cl.repository;
import Pasteleria.cl.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    // Para buscar el historial de un usuario específico
    List<Venta> findByUsuarioId(Long usuarioId);
}