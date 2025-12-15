# 🍰 Pastelería Mil Sabores - Backend API

API RESTful desarrollada con **Spring Boot 3** y **Java 17** para gestionar la plataforma de e-commerce "Pastelería Mil Sabores". Este sistema maneja la lógica de negocio, persistencia de datos, seguridad y generación de reportes.

## 🚀 Tecnologías Utilizadas

* **Java 17** (LTS)
* **Spring Boot 3.2.0** (Web, Data JPA, Security, DevTools)
* **MySQL 8** (Base de Datos Relacional)
* **JWT (JSON Web Tokens)** (Seguridad y Autenticación Stateless)
* **Lombok** (Reducción de código repetitivo)
* **SpringDoc OpenAPI** (Documentación automática con Swagger UI)
* **JUnit 5 & Mockito** (Pruebas Unitarias y Mocking)
* **iText / PDFBox** (Generación de Boletas PDF)

## 📋 Funcionalidades Principales

1.  **Seguridad Avanzada:**
    * Autenticación vía Token JWT.
    * Control de acceso basado en Roles (ADMIN, VENDEDOR, CLIENTE).
    * Encriptación de contraseñas (simulada/implementada).
2.  **Gestión de Ventas:**
    * Registro de transacciones.
    * Generación dinámica de boletas electrónicas en PDF.
3.  **Gestión de Usuarios:**
    * Registro de clientes con validación de edad.
    * CRUD completo de usuarios (Panel Admin).
4.  **Inventario:**
    * CRUD de Productos (Tortas, Pasteles).
    * Filtrado por categorías.
5.  **CORS Configurado:** Permite conexión fluida con clientes React.

## ⚙️ Configuración e Instalación

### Prerrequisitos
* Tener instalado **Java JDK 17+**.
* Tener instalado **Maven**.
* Tener **MySQL Workbench** o **XAMPP** corriendo.

### Pasos para ejecutar

1.  **Clonar el repositorio:**
    ```bash
    git clone <URL_TU_REPO>
    cd backend-pasteleria
    ```

2.  **Configurar Base de Datos:**
    * Crea una base de datos vacía en MySQL llamada `pasteleria_db`.
    * Abre `src/main/resources/application.properties` y verifica tus credenciales:
        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/pasteleria_db
        spring.datasource.username=root
        spring.datasource.password= TU_CLAVE_AQUI
        ```

3.  **Ejecutar la aplicación:**
    ```bash
    mvn spring-boot:run
    ```

4.  **Verificar ejecución:**
    * El servidor iniciará en: `http://localhost:8080`

## 📚 Documentación de API (Swagger)
Una vez iniciada la aplicación, puedes probar todos los endpoints visualmente en:
👉 **http://localhost:8080/doc**

## 🧪 Ejecutar Pruebas
El proyecto cuenta con cobertura de pruebas unitarias para los controladores principales.
```bash
mvn test
