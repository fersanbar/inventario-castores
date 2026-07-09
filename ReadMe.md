# Evaluación Técnica Castores

## Descripción

Sistema web desarrollado en **Java Spring Boot** siguiendo el patrón de arquitectura **MVC (Model - View - Controller)** para la administración de inventario de un almacén.

El sistema permite administrar productos, controlar entradas y salidas de inventario, llevar un historial de movimientos y gestionar el acceso mediante dos tipos de usuarios.

---

## Tecnologías utilizadas

- Java 21
- Spring Boot
- Spring MVC
- Spring Data JPA
- Thymeleaf
- Maven
- MySQL
- Hibernate

---

## Arquitectura

El proyecto sigue el patrón MVC.

```
Controller
    │
    ▼
Service
    │
    ▼
Repository
    │
    ▼
MySQL
```

### Estructura del proyecto

```
src
└── main
    ├── java
    │   └── com.castores.inventario
    │       ├── controller
    │       ├── model
    │       ├── repository
    │       ├── service
    │       └── InventarioApplication.java
    │
    └── resources
        ├── static
        ├── templates
        └── application.properties
```

---

# Funcionalidades

## Inicio de sesión

- Inicio de sesión mediante usuario y contraseña.
- Manejo de sesión utilizando HttpSession.

---

## Inventario

- Consultar productos.
- Agregar productos.
- Existencia inicial en 0.
- Aumentar inventario.
- Dar de baja un producto.
- Reactivar un producto.
- Visualizar productos activos e inactivos.

---

## Salida de productos

- Solo muestra productos activos.
- No permite retirar más inventario del disponible.
- Actualiza automáticamente la existencia del producto.

---

## Historial

- Registro automático de entradas y salidas.
- Se almacena:
    - Producto
    - Tipo de movimiento
    - Cantidad
    - Usuario
    - Fecha y hora
- Permite filtrar por:
    - Entrada
    - Salida

---

## Roles

### Administrador

- Ver inventario
- Agregar productos
- Aumentar inventario
- Dar de baja y reactivar productos
- Consultar historial

### Almacenista

- Ver inventario
- Realizar salida de productos

---

# Base de datos

La base de datos utilizada es:

```
inventario
```

Las tablas principales son:

- usuarios
- roles
- productos
- movimientos

---

# Usuarios de prueba

## Administrador

Correo

```
admin@castores.com
```

Contraseña

```
1234
```

---

## Almacenista

Correo

```
almacen@castores.com
```

Contraseña

```
1234
```

---

# Instalación

1. Clonar el repositorio.

```bash
git clone https://github.com/TU_USUARIO/TU_REPOSITORIO.git
```

2. Crear la base de datos.

```sql
CREATE DATABASE inventario;
```

3. Configurar las credenciales en:

```
src/main/resources/application.properties
```

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/inventario
spring.datasource.username=root
spring.datasource.password=TU_PASSWORD
```

4. Ejecutar la aplicación desde:

```
InventarioApplication.java
```

5. Abrir en el navegador:

```
http://localhost:8080
```

---

# Autor

Fernando Sánchez Barbosa