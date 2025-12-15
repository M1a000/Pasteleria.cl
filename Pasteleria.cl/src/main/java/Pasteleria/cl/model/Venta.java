package Pasteleria.cl.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long usuarioId; // Guardamos quién compró
    private String nombreUsuario; // Para verlo fácil en la base de datos
    
    private LocalDateTime fecha; // Cuándo compró
    
    @Column(length = 2000)
    private String detalleCompra; // Ej: "1x Torta Chocolate, 1x Torta Manjar"
    
    private Double totalPagado;
    private String fechaEntrega; // Lo guardaremos como String (Ej: "2023-12-25") para facilitar
    private String estado;       // Ej: "En Preparación", "En Camino", "Entregado"
}