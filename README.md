# Libros-Autores API (Spring Boot)

API RESTful para la gestión de libros y autores, desarrollada con Spring Boot, Spring Data JPA y MySQL.

## Características

- CRUD de autores y libros.
- Relación autor-libros (uno a muchos).
- Filtros y ordenación dinámica de libros mediante parámetros de consulta.
- Respuestas JSON.
- Conexión a base de datos MySQL.

## Requisitos

- Java 17+
- Maven 3.9+
- MySQL (puerto 3307, base de datos `LibrosAutoresDB`)

## Configuración

Edita el archivo `src/main/resources/application.properties` para ajustar la conexión a tu base de datos:

```properties
spring.datasource.url=jdbc:mysql://localhost:3307/LibrosAutoresDB
spring.datasource.username=root
spring.jpa.hibernate.ddl-auto=update
server.port=8084
```

## Ejecución

Compila y ejecuta el proyecto con Maven Wrapper:

```sh
./mvnw spring-boot:run
```

O en Windows:

```sh
mvnw.cmd spring-boot:run
```

La API estará disponible en [http://localhost:8084](http://localhost:8084).

## Endpoints principales

### Libros

- `GET /api/v1/libros`  
  Lista todos los libros.

- `POST /api/v1/libros`  
  Crea un nuevo libro.  
  **Body ejemplo:**
  ```json
  {
    "titulo": "Don Quijote de la Mancha",
    "isbn": "FER23123421",
    "anioPublicacion": 1980,
    "autor": { "id": 2 }
  }
  ```

- `PUT /api/v1/libros/{id}`  
  Actualiza un libro existente.

- `DELETE /api/v1/libros/{id}`  
  Elimina un libro.

- `GET /api/v1/libros/buscar?titulo=java&anioMin=2000&anioMax=2020&sortBy=titulo&order=desc`  
  Busca libros por título (parcial), rango de año y ordenación dinámica.

### Autores

- `GET /api/v1/autores`  
  Lista todos los autores.

- `POST /api/v1/autores`  
  Crea un nuevo autor.

- `DELETE /api/v1/autores/{id}`  
  Elimina un autor.

- `PUT /api/v1/autores/{id}`  
  Actualiza un autor.

## Notas

- El campo `isbn` debe ir en minúsculas en el JSON.
- Al obtener libros, el autor se muestra como objeto anidado.
- Si tienes problemas con la serialización de relaciones, revisa las anotaciones Jackson en los modelos.

## Licencia

MIT