package Pasteleria.cl.repository;

import Pasteleria.cl.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    // Busca un usuario por su email
    // Retorna "Optional" porque puede que exista o puede que no
    Optional<Usuario> findByEmail(String email);
}