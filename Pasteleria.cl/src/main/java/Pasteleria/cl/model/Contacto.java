package Pasteleria.cl.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "contactos")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    
    @Column(length = 1000) // Permitimos mensajes largos
    private String mensaje;
    
    private LocalDateTime fecha; // Para saber cuándo lo enviaron
}