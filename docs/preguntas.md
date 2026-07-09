# Respuestas - Evaluación Técnica Castores

## 1. Describe el funcionamiento general de la sentencia JOIN.

La sentencia **JOIN** se utiliza para unir dos o más tablas mediante una condición, permitiendo obtener información relacionada entre ellas.

---

## 2. ¿Cuáles son los tipos de JOIN y cuál es el funcionamiento de los mismos?

### INNER JOIN

Devuelve únicamente los registros que tienen coincidencias en ambas tablas. Si un registro no tiene coincidencia, se descarta.

### LEFT JOIN

Devuelve todos los registros de la tabla de la izquierda y los registros coincidentes de la tabla de la derecha. Si no existe coincidencia, los campos de la tabla derecha se muestran con valores `NULL`.

### RIGHT JOIN

Devuelve todos los registros de la tabla de la derecha y los registros coincidentes de la tabla de la izquierda. Si no existe coincidencia, los campos de la tabla izquierda se muestran con valores `NULL`.

### FULL JOIN

Devuelve todos los registros de ambas tablas. Cuando no existe coincidencia entre ellas, los campos correspondientes se completan con valores `NULL`.

---

## 3. ¿Cuál es el funcionamiento general de los TRIGGER y qué propósito tienen?

Un **TRIGGER** es un procedimiento que se ejecuta automáticamente cuando ocurre un evento sobre una tabla, como un `INSERT`, `UPDATE` o `DELETE`.

Su propósito es automatizar tareas, validar información y aplicar reglas de negocio dentro de la base de datos.

---

## 4. ¿Qué es y para qué sirve un STORED PROCEDURE?

Un **Stored Procedure** es un conjunto de instrucciones SQL almacenadas en la base de datos que pueden ejecutarse cuando se requieren.

Sirve para mejorar el rendimiento, reutilizar código, reducir la duplicación de consultas y centralizar la lógica de acceso a los datos.