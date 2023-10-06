# Descripción del proyecto "Lista de Tareas (Consola)"

## Descripción:
El proyecto de "Lista de Tareas (Consola)" es una aplicación de consola que te permite crear, gestionar y mantener un listado de tareas pendientes. Los usuarios podrán agregar tareas, marcarlas como completadas, eliminarlas y ver la lista de tareas en cualquier momento.

## Características clave:

1. Menú de opciones: La aplicación debe mostrar un menú de opciones que permita al usuario elegir entre agregar una nueva tarea, ver la lista de tareas, marcar tareas como completadas o eliminar tareas.

2. Agregar tareas: Los usuarios pueden ingresar una descripción de la tarea que desean agregar y la aplicación la registrará en la lista de tareas pendientes.

3. Ver lista de tareas: La aplicación debe mostrar la lista de tareas pendientes, indicando cuáles están completadas y cuáles no.

4. Marcar tareas como completadas: Los usuarios deben poder marcar una tarea como completada, lo que cambiará su estado en la lista.

5. Eliminar tareas: La aplicación debe permitir a los usuarios eliminar tareas que ya no deseen mantener en la lista.

6. Guardar y cargar datos: Puedes implementar la funcionalidad de guardar la lista de tareas en un archivo para que los usuarios puedan recuperarla en futuras sesiones.

## Ejemplo de flujo de trabajo:

1. La aplicación muestra un menú de opciones:

```text
Lista de Tareas
1. Agregar tarea
2. Ver lista de tareas
3. Marcar tarea como completada
4. Eliminar tarea
5. Salir
Seleccione una opción:
```
2. El usuario elige "Agregar tarea" e ingresa una descripción de la tarea (por ejemplo, "Hacer la compra").

3. La aplicación agrega la tarea a la lista de tareas pendientes.

4. El usuario puede seleccionar "Ver lista de tareas" para ver la lista actualizada:

```text
Lista de Tareas Pendientes:
1. Hacer la compra (Pendiente)
```

5. Luego, el usuario puede marcar la tarea como completada, eliminarla o realizar otras acciones según su necesidad.

## Requisitos adicionales:

* Manejo de errores: Debes manejar posibles errores, como la elección de opciones inválidas o la modificación de tareas que no existen.
* Persistencia de datos: Puedes implementar la funcionalidad de guardar y cargar la lista de tareas en un archivo para mantener la información entre sesiones.