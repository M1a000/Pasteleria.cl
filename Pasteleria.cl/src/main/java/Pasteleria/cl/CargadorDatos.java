package Pasteleria.cl;

import Pasteleria.cl.model.Articulo;
import Pasteleria.cl.model.Producto;
import Pasteleria.cl.model.Usuario;
import Pasteleria.cl.repository.ArticuloRepository;
import Pasteleria.cl.repository.ProductoRepository;
import Pasteleria.cl.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class CargadorDatos implements CommandLineRunner {

    private final ProductoRepository productoRepository;
    private final ArticuloRepository articuloRepository;
    private final UsuarioRepository usuarioRepository;

    public CargadorDatos(ProductoRepository productoRepository,
                         ArticuloRepository articuloRepository,
                         UsuarioRepository usuarioRepository) {
        this.productoRepository = productoRepository;
        this.articuloRepository = articuloRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // --- 1. CARGA DE PRODUCTOS (10 TORTAS VARIADAS) ---
        if (productoRepository.count() == 0) {

            // --- TORTAS CUADRADAS ---
            Producto p1 = new Producto();
            p1.setCodigo("TC001");
            p1.setCategoria("Tortas Cuadradas");
            p1.setNombre("Torta Cuadrada de Chocolate");
            p1.setDescripcion("Deliciosa torta de chocolate intenso con capas de ganache y un toque de avellanas europeas.");
            p1.setPrecio(45000);
            p1.setForma("Cuadrada");
            p1.setImagenUrl("https://images.unsplash.com/photo-1578985545062-69928b1d9587");
            productoRepository.save(p1);

            Producto p2 = new Producto();
            p2.setCodigo("TC002");
            p2.setCategoria("Tortas Cuadradas");
            p2.setNombre("Torta Cuadrada de Frutas");
            p2.setDescripcion("Fresca y ligera. Bizcocho de vainilla, crema chantilly y una selección de frutas de la estación.");
            p2.setPrecio(50000);
            p2.setForma("Cuadrada");
            p2.setImagenUrl("https://images.unsplash.com/photo-1565958011703-44f9829ba187");
            productoRepository.save(p2);


            Producto p4 = new Producto();
            p4.setCodigo("TC004");
            p4.setCategoria("Tortas Cuadradas");
            p4.setNombre("Tres Leches Especial");
            p4.setDescripcion("Bizcocho extremadamente húmedo remojado en tres leches, cubierto con merengue italiano tostado.");
            p4.setPrecio(42000);
            p4.setForma("Cuadrada");
            p4.setImagenUrl("https://images.unsplash.com/photo-1464349095431-e9a21285b5f3?auto=format&fit=crop&w=600&q=80");
            productoRepository.save(p4);

            // --- TORTAS CIRCULARES ---
            Producto p5 = new Producto();
            p5.setCodigo("TT001");
            p5.setCategoria("Tortas Circulares");
            p5.setNombre("Torta Circular de Vainilla");
            p5.setDescripcion("Sencilla y elegante. Bizcocho de vainilla esponjoso relleno con crema pastelera y mermelada.");
            p5.setPrecio(40000);
            p5.setForma("Circular");
            p5.setImagenUrl("https://images.unsplash.com/photo-1535141192574-5d4897c12636");
            productoRepository.save(p5);

            Producto p6 = new Producto();
            p6.setCodigo("TT002");
            p6.setCategoria("Tortas Circulares");
            p6.setNombre("Panqueque Naranja");
            p6.setDescripcion("La favorita de la casa. Finas capas de bizcocho panqueque rellenas con crema de naranja natural.");
            p6.setPrecio(52000);
            p6.setForma("Circular");
            p6.setImagenUrl("https://images.unsplash.com/photo-1562007908-17c67e878c88?q=80&w=800&auto=format&fit=crop");
            productoRepository.save(p6);

            Producto p7 = new Producto();
            p7.setCodigo("TT003");
            p7.setCategoria("Tortas Circulares");
            p7.setNombre("Cheesecake Frutos Rojos");
            p7.setDescripcion("Base de galleta crocante, relleno cremoso de queso y cubierta de salsa de frambuesas y arándanos.");
            p7.setPrecio(46000);
            p7.setForma("Circular");
            p7.setImagenUrl("https://images.unsplash.com/photo-1533134242443-d4fd215305ad?auto=format&fit=crop&w=600&q=80");
            productoRepository.save(p7);

            Producto p8 = new Producto();
            p8.setCodigo("TT004");
            p8.setCategoria("Tortas Circulares");
            p8.setNombre("Selva Negra");
            p8.setDescripcion("Bizcocho de chocolate, crema chantilly, mermelada de guinda y trozos de chocolate.");
            p8.setPrecio(48000);
            p8.setForma("Circular");
            p8.setImagenUrl("https://images.unsplash.com/photo-1571115177098-24ec42ed204d?auto=format&fit=crop&w=600&q=80");
            productoRepository.save(p8);

            // --- PRODUCTOS VEGANOS ---
            Producto p9 = new Producto();
            p9.setCodigo("PV001");
            p9.setCategoria("Productos Veganos");
            p9.setNombre("Torta Vegana de Chocolate");
            p9.setDescripcion("Increíble sabor sin ingredientes de origen animal. Bizcocho húmedo de cacao y ganache de coco.");
            p9.setPrecio(50000);
            p9.setForma("Circular");
            p9.setImagenUrl("https://images.unsplash.com/photo-1606890737304-57a1ca8a5b62");
            productoRepository.save(p9);

            Producto p10 = new Producto();
            p10.setCodigo("PV002");
            p10.setCategoria("Productos Veganos");
            p10.setNombre("Carrot Cake Vegano");
            p10.setDescripcion("Pastel de zanahoria especiado con nueces y un frosting cremoso a base de castañas de cajú.");
            p10.setPrecio(54000);
            p10.setForma("Circular");
            p10.setImagenUrl("https://images.unsplash.com/photo-1621303837174-89787a7d4729?auto=format&fit=crop&w=600&q=80");
            productoRepository.save(p10);

            System.out.println("✅ ¡10 PRODUCTOS CARGADOS!");
        }

        // --- 2. CARGA DE ARTÍCULOS DE BLOG ---
        if (articuloRepository.count() == 0) {

            Articulo a1 = new Articulo();
            a1.setTitulo("El secreto para un merengue perfecto");
            a1.setAutor("Juan Pérez - Estudiante Gastronomía Duoc");
            a1.setCategoria("Tips de Repostería");
            a1.setFecha(LocalDate.now().minusDays(2));
            a1.setImagenUrl("https://images.unsplash.com/photo-1571115177098-24ec42ed204d");
            a1.setContenido("Muchos fallan en el merengue porque los huevos están fríos. El truco que aprendimos en clase es usar claras a temperatura ambiente y añadir el azúcar en forma de lluvia muy lenta mientras se bate a velocidad media.");
            articuloRepository.save(a1);

            Articulo a2 = new Articulo();
            a2.setTitulo("Receta: Galletas de Avena en 15 minutos");
            a2.setAutor("María González - 3er Año");
            a2.setCategoria("Recetas Rápidas");
            a2.setFecha(LocalDate.now().minusDays(5));
            a2.setImagenUrl("https://images.unsplash.com/photo-1558961363-fa8fdf82db35");
            a2.setContenido("No necesitas harina refinada. Solo mezcla 2 tazas de avena, 2 plátanos maduros y chips de chocolate. Hornea a 180°C y listo. ¡Ideal para tener energía durante los exámenes!");
            articuloRepository.save(a2);

            Articulo a3 = new Articulo();
            a3.setTitulo("La historia de la Torta de Mil Hojas");
            a3.setAutor("Profe. Carlos - Instructor Duoc");
            a3.setCategoria("Cultura");
            a3.setFecha(LocalDate.now().minusWeeks(1));
            a3.setImagenUrl("https://images.unsplash.com/photo-1535141192574-5d4897c12636");
            a3.setContenido("Esta torta es un clásico chileno influenciado por la repostería francesa. La clave está en una masa muy delgada y crocante intercalada con manjar de buena calidad.");
            articuloRepository.save(a3);

            System.out.println("✅ ¡BLOG CARGADO!");
        }

        // --- 3. CARGA DE USUARIOS CON ROLES ---
        if (usuarioRepository.count() == 0) {

            // ADMIN
            Usuario admin = new Usuario();
            admin.setNombre("Administrador");
            admin.setEmail("admin@mil.cl");
            admin.setPassword("123456");
            admin.setRol("ADMIN");
            admin.setFechaNacimiento(LocalDate.of(1980, 1, 1));
            usuarioRepository.save(admin);

            // VENDEDOR
            Usuario vendedor = new Usuario();
            vendedor.setNombre("Vendedor Estrella");
            vendedor.setEmail("vendedor@mil.cl");
            vendedor.setPassword("123456");
            vendedor.setRol("VENDEDOR");
            vendedor.setFechaNacimiento(LocalDate.of(1990, 5, 15));
            usuarioRepository.save(vendedor);

            // CLIENTE
            Usuario cliente = new Usuario();
            cliente.setNombre("Cliente Frecuente");
            cliente.setEmail("cliente@mil.cl");
            cliente.setPassword("123456");
            cliente.setRol("CLIENTE");
            cliente.setFechaNacimiento(LocalDate.of(1995, 8, 20));
            usuarioRepository.save(cliente);

            System.out.println("✅ ¡USUARIOS CREADOS!");
        }
    }
}