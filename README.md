# TechStore API

Microservicio RESTful desarrollado con **Java + Spring Boot** para la gestión de productos de la tienda ficticia TechStore Chile.

## Tecnologías utilizadas

- Java 17
- Spring Boot 3.5.14
- Spring Security + JWT
- Spring Data JPA / Hibernate
- Oracle Autonomous Database (OCI)
- Maven

## Requisitos previos

- Java 17 instalado
- Maven o usar el wrapper `mvnw` incluido
- Wallet de Oracle ADB en `src/main/resources/wallet/`

## Clonar el repositorio

```bash
git clone https://github.com/DanielVillalo/techstore-api.git
cd techstore-api
```

## Configuración

1. Descomprime el wallet de Oracle ADB en `src/main/resources/wallet/`
2. Edita `src/main/resources/application.properties` con tus credenciales:

```properties
spring.datasource.url=jdbc:oracle:thin:@techstoredb_tp?TNS_ADMIN=src/main/resources/wallet
spring.datasource.username=ADMIN
spring.datasource.password=TU_PASSWORD
```

## Compilar y ejecutar

```bash
# Compilar
./mvnw clean compile

# Empaquetar
./mvnw clean package -DskipTests

# Ejecutar el JAR
java -jar target/api-0.0.1-SNAPSHOT.jar

# O ejecutar directamente con Maven
./mvnw spring-boot:run
```

## Endpoints disponibles

### Autenticación

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/auth/login` | Obtener token JWT |

**Body:**
```json
{
    "username": "admin@techstore.cl",
    "password": "Admin1234"
}
```

### Productos (requieren Authorization: Bearer token)

| Método | Endpoint | Descripción | HTTP |
|--------|----------|-------------|------|
| GET | `/api/productos` | Listar todos | 200 |
| POST | `/api/productos` | Crear producto | 201 |
| PUT | `/api/productos/{id}` | Modificar producto | 200 |
| DELETE | `/api/productos/{id}` | Borrado lógico | 204 |

**Body para crear/modificar:**
```json
{
    "nombre": "Laptop Lenovo IdeaPad",
    "descripcion": "Notebook 15.6 pulgadas, 8GB RAM, 512GB SSD",
    "precio": 499990,
    "stock": 15,
    "categoria": "Computación",
    "activo": true
}
```

## Estructura del proyecto

```
src/main/java/cl/techstore/api/
├── controller/
│   ├── AuthController.java
│   └── ProductoController.java
├── dto/
│   ├── LoginRequest.java
│   ├── LoginResponse.java
│   └── ProductoDTO.java
├── model/
│   └── Producto.java
├── repository/
│   └── ProductoRepository.java
├── security/
│   ├── JwtFilter.java
│   ├── JwtUtil.java
│   └── SecurityConfig.java
├── service/
│   └── ProductoService.java
└── ApiApplication.java
```