package Pasteleria.cl.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    // Creamos una llave secreta segura para firmar los tokens
    private static final Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Método para generar el Token
    public String generarToken(Long id, String rol, String nombre) {
        return Jwts.builder()
                .setSubject(id.toString()) // Guardamos el ID en el token
                .claim("rol", rol)         // Guardamos el Rol
                .claim("nombre", nombre)   // Guardamos el Nombre
                .setIssuedAt(new Date())   // Fecha de creación (Ahora)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Expira en 10 horas
                .signWith(KEY)             // Firmamos con nuestra llave secreta
                .compact();
    }
}