# Microservice User 👤🔐

Este repositorio contiene el **Microservicio de Usuarios (User)**, encargado de la gestión crítica de identidad, autenticación, registro de usuarios y la emisión segura de tokens **JWT (JSON Web Token)** con sus respectivos roles y permisos dentro del ecosistema de microservicios.

Está construido siguiendo los principios de **Arquitectura Hexagonal**, desacoplando la lógica de negocio de los adaptadores de infraestructura, y utiliza **Spring Security** para manejar la autenticación sin estado (*stateless*).
![Arquitectura](microservice_user.jfif)

## 🚀 Tecnologías y Versiones

* **Java:** 17

* **Spring Boot:** 3.5.3

* **Spring Cloud:** (Integración con Eureka Discovery y Gateway)

* **Spring Security & JWT:** Autenticación, encriptación de credenciales y generación de tokens sin estado.

* **Base de Datos:** MySQL (Configuración centralizada gestionada a través del servidor de configuraciones).

* **Patrón de Arquitectura:** Arquitectura Hexagonal (Ports and Adapters).

## 🏗️ Arquitectura del Ecosistema

Este microservicio es una pieza fundamental del ecosistema, ya que actúa como el proveedor de autenticación y seguridad para el resto de servicios (como el microservicio de Stock). Las configuraciones de conexión se cargan dinámicamente desde el servidor centralizado.

El orden recomendado para levantar el ecosistema completo es el siguiente:

1. **`microservice-eureka`** (Servidor de descubrimiento de servicios)

2. **`microservice-config`** (Servidor de configuraciones centralizadas en `.yaml`)

3. **`microservice-gateway`** (Punto de entrada y enrutamiento hacia el ecosistema)

4. **`microservice-user`** (Este microservicio: Autenticación, registro y emisor de tokens JWT)

5. **Demas microservicios de negocio** (como **`microservice-stock`**, transacciones, etc.)

## 🔒 Endpoints Principales y Seguridad

El microservicio expone los puntos de entrada necesarios para que los usuarios puedan registrarse, iniciar sesión y obtener su token de acceso con los privilegios correspondientes.

* **Registro de Usuarios:** Permite dar de alta nuevos usuarios en el sistema asignando sus roles iniciales.
* **Inicio de Sesión (Login):** Valida las credenciales contra la base de datos MySQL y retorna el token JWT firmado que será utilizado para consumir los demás microservicios protegidos.

## 📂 Estructura Hexagonal del Proyecto

El código fuente respeta la separación de responsabilidades:

* **`domain`**: Entidades de usuario, objetos de valor y reglas de negocio puras (independientes de librerías externas).
* **`application`**: Casos de uso orientados a la autenticación, registro y generación de tokens.
* **`infrastructure`**: Adaptadores de entrada (Controladores REST y filtros de seguridad) y adaptadores de salida (Persistencia JPA con MySQL y repositorios de datos).

## ⚙️ Configuración y Ejecución

Dado que las credenciales y propiedades de la base de datos residen en el **`microservice-config`**, asegúrate de que dicho servicio esté activo previamente.

1. Clona el repositorio y verifica que cuentas con Java 17.
2. Levanta los servicios base en el orden correcto (Eureka -> Config -> Gateway).
3. Compila y ejecuta este microservicio ejecutando:

   ```bash
   ./mvnw clean spring-boot:run
