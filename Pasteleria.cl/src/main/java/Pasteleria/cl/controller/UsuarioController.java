package Pasteleria.cl.controller;

import Pasteleria.cl.model.Usuario;
import Pasteleria.cl.repository.UsuarioRepository;
import Pasteleria.cl.service.JwtService; // <--- IMPORTANTE
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap; // <--- IMPORTANTE
import java.util.List;
import java.util.Map;     // <--- IMPORTANTE

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioRepository repository;
    private final JwtService jwtService; // <--- Inyectamos el servicio JWT

    public UsuarioController(UsuarioRepository repository, JwtService jwtService) {
        this.repository = repository;
        this.jwtService = jwtService;
    }

    // ... (Mantén obtenerTodos y registrarUsuario igual que antes) ...
    @GetMapping
    public List<Usuario> obtenerTodos() { return repository.findAll(); }

    @PostMapping("/registro")
    public Usuario registrarUsuario(@RequestBody Usuario usuario) {
        if (usuario.getFechaNacimiento() == null) usuario.setFechaNacimiento(LocalDate.now());
        if (usuario.getRol() == null || usuario.getRol().isEmpty()) usuario.setRol("CLIENTE");
        return repository.save(usuario);
    }

    // --- LOGIN MODIFICADO PARA JWT ---
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Usuario usuario) {
        Usuario encontrado = repository.findByEmail(usuario.getEmail()).orElse(null);
        
        if (encontrado != null && encontrado.getPassword().equals(usuario.getPassword())) {
            // 1. Generamos el Token
            String token = jwtService.generarToken(encontrado.getId(), encontrado.getRol(), encontrado.getNombre());

            // 2. Preparamos la respuesta (Usuario + Token)
            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("usuario", encontrado);
            respuesta.put("token", token); // <--- AQUÍ VA EL JWT
            
            return respuesta;
        }
        return null;
    }

    // ... (Mantén actualizarPerfil, editarUsuarioAdmin y eliminarUsuario igual) ...
    @PutMapping("/actualizar")
    public Usuario actualizarPerfil(@RequestBody Usuario u) {
        Usuario or = repository.findById(u.getId()).orElse(null);
        if (or != null) {
            or.setNombre(u.getNombre()); or.setEmail(u.getEmail()); or.setPassword(u.getPassword()); or.setPreferencias(u.getPreferencias());
            return repository.save(or);
        }
        return null;
    }

    @PutMapping("/{id}")
    public Usuario editarUsuarioAdmin(@PathVariable Long id, @RequestBody Usuario u) {
        return repository.findById(id).map(usr -> {
            usr.setNombre(u.getNombre()); usr.setEmail(u.getEmail()); usr.setPassword(u.getPassword()); usr.setRol(u.getRol());
            return repository.save(usr);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) { repository.deleteById(id); }
}