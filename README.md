[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/O1oNnYGo)

# AlquilerCoches

## Descripción del proyecto  
AlquilerCoches es una aplicación Android de gestión de vehículos de alquiler. En el móvil, el usuario puede ver un listado de coches, consultar sus detalles, crear, modificar y eliminar registros. El backend, desarrollado con Spring Boot y MySQL, expone una API REST que gestiona peticiones de consulta (GET), creación (POST), actualización (PUT) y borrado (DELETE).

---

## Requisitos implementados  

### 1. Aplicación Android  
- **RF-AN-01** Pantalla de listado de coches — implementado  
- **RF-AN-02** Formulario para crear nuevos coches — implementado  
- **RF-AN-03** Navegación entre listado y creación — implementado  
- **RF-AN-04** Diseño con Material3 y Jetpack Compose — implementado  
- **RF-AN-05** Pantalla de login — implementado  
- **RF-AN-06** Pantalla de registro — implementado  
- **RF-AN-07** Pantalla de consulta de datos de un coche — implementado  
- **RF-AN-08** Formulario de modificación de un coche — implementado  
- **RF-AN-09** Botón de eliminación en listado y detalle — parcialmente implementado  
- **RF-AN-10** Widget de selección para campos predefinidos — parcialmente implementado (valores en lista local)  
- **RF-AN-11** Paginación, ordenación y búsqueda en el listado — parcialmente implementado

### 2. API REST (PSP)  
- **RF-API-01** Endpoint POST `/api/coches` — implementado  
- **RF-API-02** Endpoint GET `/api/coches` — implementado  
- **RF-API-03** Endpoint GET `/api/coches/{id}` — implementado  
- **RF-API-04** Endpoint PUT `/api/coches/{id}` — implementado  
- **RF-API-05** Endpoint DELETE `/api/coches/{id}` — implementado  
- **RF-API-06** Paginación en respuestas GET — parcialmente implementado (backend preparado, front no usa)  
- **RF-API-07** Ordenación de resultados — no implementado  
- **RF-API-08** Filtrado por parámetro — parcialmente implementado(búsqueda por marca de coche)  
- **RF-API-09** GET para valores de campo (p. ej. marcas) — no implementado  
- **RF-API-10** Endpoint para login de usuarios — implementado  
- **RF-API-11** Endpoint para registro de usuarios — implementado  

### 3. Acceso a datos (ADA)  
- **RF-BD-01** Entidad principal “Coche” con ≥ 4 atributos — implementado  
- **RF-BD-02** Al menos 4 entidades con relaciones — implementado (Coche, Usuario, Alquiler, Pago)  
- **RF-BD-03** Relación 1-n con valores predefinidos — implementado (Coche ← Alquiler)  
- **RF-BD-04** Consultas de búsqueda y filtrado — no implementado  
- **RF-BD-05** Consulta de elemento por ID — implementado  
- **RF-BD-06** Actualización de elemento en BBDD — implementado  
- **RF-BD-07** Supresión de elemento en BBDD — implementado 
- **RF-BD-08** Autenticación y registro de usuarios — implementado  

### 4. Pruebas y calidad  
- **RT-PR-01** Pruebas unitarias API (mín. 2 por endpoint) — no implementado 
- **RT-PR-02** Pruebas unitarias en Android — parcialmente implementado (view models)  
- **RT-PR-03** Pruebas unitarias capa de persistencia — no implementado  
- **RT-PR-04** Uso de frameworks JUnit, Mockito — parcialmente implementado  

---

## Enlace al vídeo de presentación  
https://eepmad-my.sharepoint.com/:v:/g/personal/miguel-paredero1_eep-igroup_com/Eb23UCf-AmxEmleZnCBHy7EBskyLH_Pey8eD_7Qy3khtEQ?e=oDhDAw&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D

# TAMBIÉN TENGO 1 SP EN PSP Y 3 SP EN ADA DE LOS "DIAS DE OFICINA" EN CLASE

- MIGUEL PAREDERO ALONSO
DAM
