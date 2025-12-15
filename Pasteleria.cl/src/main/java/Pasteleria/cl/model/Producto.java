package Pasteleria.cl.model;

import jakarta.persistence.*;
import lombok.Data;

@Data // Esto genera automáticamente los Getters, Setters y toString
@Entity // Esto le dice a Spring que esta clase es una tabla en la Base de Datos
@Table(name = "productos") // El nombre real que tendrá la tabla en MySQL
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // El ID se autoincrementa (1, 2, 3...)
    private Long id;

    // Código del producto (Ej: TC001) - unique=true impide que se repitan
    @Column(nullable = false, unique = true)
    private String codigo; 

    // Categoría (Ej: Tortas Cuadradas, Veganas, Sin Gluten)
    private String categoria; 

    // Nombre (Ej: Torta Cuadrada de Chocolate)
    private String nombre; 

    // Descripción larga (le damos espacio para 1000 caracteres)
    @Column(length = 1000) 
    private String descripcion;

    // Precio en pesos chilenos
    private Integer precio;

    // Forma (Cuadrada, Circular) - Requerido para el filtro del PDF
    private String forma; 
    
    // URL de la imagen (para mostrar la foto en React más adelante)
    private String imagenUrl; 
}