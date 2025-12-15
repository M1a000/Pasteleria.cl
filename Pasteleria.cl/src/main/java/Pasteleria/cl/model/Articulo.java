package Pasteleria.cl.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "articulos")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor; // Ej: "Juan Pérez - Estudiante Duoc"
    private String categoria; // Ej: "Recetas", "Noticias"
    private LocalDate fecha; 
    
    private String imagenUrl;

    @Column(length = 5000) // Permitimos textos largos (hasta 5000 letras)
    private String contenido;
}