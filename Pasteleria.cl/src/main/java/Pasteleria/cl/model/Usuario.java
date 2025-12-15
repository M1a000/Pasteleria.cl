package Pasteleria.cl.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre completo del cliente
    private String nombre;
    
    // El email debe ser único (no pueden haber dos cuentas con el mismo correo)
    @Column(unique = true, nullable = false)
    private String email;
    
    // Contraseña (en una app real la encriptaríamos, por ahora la guardaremos normal)
    private String password; 
    
    // IMPORTANTE: Necesitamos esto para calcular si tiene más de 50 años
    private LocalDate fechaNacimiento; 
    
    // Campo para saber si se registró con el código "FELICES50" (Descuento 10% de por vida)
    private boolean descuentoVitalicio; 
    // Campo para que el usuario tenga sus preferencias
    @Column(length = 500)
    private String preferencias;
    // ROL: "CLIENTE", "VENDEDOR", "ADMIN"
    private String rol;
}