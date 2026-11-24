# Gestión Académica en Java (Consola)

Ejercicio práctico en Java por consola para afinar la lógica entre capas (`controller`, `service`, `repository`, `dto`, `entity`, `mapper`) y las relaciones entre entidades (`Student`, `Course` y `Enrollment`) usando almacenamiento en memoria.

## Qué practica este ejercicio
- **Inyección de dependencias manual:** Instanciación y cableado de `dbLocal` (Singleton), repositorios, servicios y controladores desde `Main`.
- **Relación entre entidades:** Gestión de estudiantes, cursos y matrículas (`Enrollment`), consultando perfiles completos de alumnos e inscritos por curso.
- **Pruebas de flujo directo:** Simulación de llamadas CRUD directamente desde `Main` sin depender de menús interactivos.

## Estructura de paquetes
- `pkg02_gestionacademica.controller`: `StudentController`, `CourseController`, `EnrollmentController`
- `pkg02_gestionacademica.service`: Lógica de negocio e implementaciones
- `pkg02_gestionacademica.repository` y `dbLocalSimulado`: Persistencia simulada en memoria
- `pkg02_gestionacademica.entity`, `dto` y `mapper`: Modelos, contratos y conversión de datos
- `pkg02_gestionacademica.util`: Utilidades de parseo

## Ejecución
Abrir el proyecto en NetBeans o compilar los paquetes dentro de `src/` y ejecutar `pkg02_gestionacademica.Main`.
