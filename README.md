[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/O1oNnYGo)

# AlquilerCoches

## 1. Descripción
AlquilerCoches es una aplicación cuya usabilidad es para gestionar el alquiler de coches como su nombre dice, vemos que es muy intuitivo jajaja.  
- La parte móvil se ha desarrollado en Android (Kotlin + Jetpack Compose).  
- El backend es una API REST en Spring Boot que usa MySQL y JPA/Hibernate.  
- Se gestionan cuatro entidades relacionadas: Usuario, Coche, Alquiler y Pago.

## 2. Requisitos implementados

### 2.1 Concepto general (30%)  
- Aplicación Android que hace peticiones REST a un servidor Spring que se conecta a una base de datos para manejar datos de alguna entidad relacionada con el tema propuesto (RF-AN-01, RF-AN-02, RF-AN-03): implementado.

### 2.2 Android
- Aplicación de mínimo dos pantallas, capaz de listar todos los elementos y añadir nuevos  
  - RF-AN-01, RF-AN-02, RF-AN-03: implementado  
- Pantalla de consulta de los datos de un elemento  
  - RF-AN-07: implementado  
- Formulario de modificación de los elementos  
  - RF-AN-08: implementado  
- Botón de eliminación de un elemento (en listado y en pantalla de detalle)  
  - RF-AN-09: implementado  
- Widget de selección para valores predefinidos en creación/modificación  
  - RF-AN-10: no implementado  
- Listado con paginación, ordenación y criterios de búsqueda  
  - RF-AN-11: no implementado  
- Pantallas de login y registro de usuarios  
  - RF-AN-05, RF-AN-06: implementado  
- Diseño y usabilidad  
  - RF-AN-04: implementado  

### 2.3 PSP  
- Endpoint POST para crear un nuevo elemento  
  - RF-API-01: implementado  
- Endpoint GET para recuperar todos los elementos  
  - RF-API-02: implementado  
- Endpoint GET para recuperar un elemento por ID  
  - RF-API-03: implementado  
- Endpoint PUT para modificar un elemento existente  
  - RF-API-04: implementado  
- Endpoint DELETE para eliminar un elemento  
  - RF-API-05: implementado  
- GET con paginación, ordenación y filtrado  
  - RF-API-06: implementado (paginación)  
  - RF-API-07: no implementado (ordenación)  
  - RF-API-08: implementado (filtrado)  
- GET para recuperar valores posibles de un campo  
  - RF-API-09: no implementado  
- Endpoint para autenticación (login)  
  - RF-API-10: implementado  
- Endpoint para registro de nuevos usuarios  
  - RF-API-11: implementado  

### 2.4 ADA 
- Entidad principal con al menos cuatro atributos  
  - RF-BD-01: implementado  
- Al menos cuatro entidades con relaciones entre ellas  
  - RF-BD-02: implementado  
- Relación uno-a-muchos entre entidad principal y secundaria  
  - RF-BD-03: implementado  
- Consultas que permitan filtrar y buscar información  
  - RF-BD-04: implementado  
- Consulta de un elemento por su identificador único  
  - RF-BD-05: implementado  
- Actualización de datos de un elemento existente  
  - RF-BD-06: implementado  
- Supresión de un elemento existente  
  - RF-BD-07: implementado  
- Autenticación y registro de usuarios con credenciales seguras  
  - RF-BD-08: implementado  parcialmente

##APARTE TENGO 3 SP DE ADAY 1 SP DE PSP SI NO ME EQUIVOCO DE LOS DÍAS DE OFICINA 

## 3. Enlace al vídeo de presentación  
https://streams.escuela.edu/alquilercoches-presentacion  

