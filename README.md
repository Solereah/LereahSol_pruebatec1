# Documentación de HRSoft
## Sistema de Administración de Recursos Humanos
### Prueba Técnica del Módulo Java Básico para Bootcamp Hack A Boss
<img src= "https://media.tenor.com/4UklEAR-r8EAAAAd/ki-cargo-hr.gif"/>
<p>
  HRConnect es una aplicación Java diseñada para administrar la información de los empleados de una organización mediante el uso de Java Persistence API (JPA). A continuación, se explica el funcionamiento de las principales funcionalidades.
</p>
<h2>Funcionalidades Principales</h2>
<ol>
  <li>
    <h3><b>Agregar un Nuevo Empleado</b></h3>
    <p>Permite registrar la información de un nuevo empleado, incluyendo nombre, apellido, cargo, salario y fecha de inicio.</p>
    <h4>Instrucciones: </h4>  
    <p>Selecciona la opción 1 en el menú principal.
    Ingresa la información solicitada.</p>
  </li> 
<li>
  <h3>Listar Empleados</h3>
  <p>Muestra la lista de todos los empleados registrados en el sistema.</p>
  <h4>Instrucciones:</h4>
<P>Selecciona la opción 2 en el menú principal.</P>

</li>
<li>
<h3>Actualizar Información de un Empleado</h3>
<p>Permite modificar los datos de un empleado existente, incluyendo nombre, apellido, cargo, salario y fecha de inicio.</p>
<h4>Instrucciones:</h4>
<p>Selecciona la opción 3 en el menú principal.
Ingresa el ID del empleado que deseas modificar.
Sigue las instrucciones para seleccionar el campo a modificar y proporcionar el nuevo valor.</p>
</li>
<li>
<h3>Eliminar un Empleado</h3>
<p>Permite eliminar un empleado del sistema.</p>
<h4>Instrucciones:</h4>
<p>Selecciona la opción 4 en el menú principal.
Ingresa el ID del empleado que deseas eliminar.
Confirma la eliminación.</p>
</li>
<li><h3>Buscar Empleados por Cargo</h3>
<p>Filtra y muestra los empleados según el cargo especificado.</p>
<h4>Instrucciones:</h4>
<p>Selecciona la opción 5 en el menú principal.
Ingresa el cargo por el cual deseas filtrar.</p>
</li>
</ol>

<h3>Validaciones de Entrada de Datos</h3>
La aplicación HRConnect incluye un conjunto de validaciones de entrada de datos para garantizar la información almacenada en la base de datos MySQL. 
A continuación se detallan las validaciones realizadas para cada funcionalidad:

1. Agregar un Nuevo Empleado
**Validación de campos** requeridos:
Se asegura de que todos los campos obligatorios (nombre, apellido, cargo, salario, fecha de inicio) sean proporcionados antes de realizar el registro.
**Validación de datos válidos**:
Cada campo se somete a verificaciones para asegurarse de que los datos ingresados sean válidos y cumplan con los criterios establecidos.
2. Listar Empleados
Sin Validaciones Específicas:
Dado que esta funcionalidad solo implica la recuperación y presentación de datos, no se aplican validaciones específicas en este contexto.
3. Actualizar Información de un Empleado
**Validación de ID existente**:
Antes de permitir la modificación, se verifica que el ID proporcionado corresponda a un empleado existente en la base de datos.
Validación de Campos Modificables:
Se asegura de que solo se puedan modificar los campos específicos (nombre, apellido, cargo, salario, fecha de inicio) y que los datos modificados sean válidos.
4. Eliminar un Empleado
**Validación de ID existente**:
Antes de proceder con la eliminación, se verifica que el ID proporcionado corresponda a un empleado existente en la base de datos.
5. Buscar Empleados por Cargo
**Validación de cargo cálido**:
Se verifica que el cargo ingresado para la búsqueda sea válido y exista en la base de datos.
6. Menú Principal
**Validación de Opciones del Menú**:
El sistema garantiza que solo se puedan seleccionar opciones válidas del menú principal (opciones del 1 al 5).
Manejo de Opciones No Válidas:

Además se implementa un mecanismo para manejar **opciones no válidas** proporcionando mensajes de error claros para que el usuario pueda saber que falló. 


