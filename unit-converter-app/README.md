# Convertidor de Unidades

## Descripción
El proyecto de "Convertidor de Unidades (Consola)" se trata de crear una aplicación de consola en Java que permita a los usuarios convertir entre diferentes unidades de medida, como longitud, peso, temperatura, velocidad u otras, según la elección del usuario.

## Características clave:

1. Menú de opciones: La aplicación debe mostrar un menú de opciones que permita al usuario elegir la categoría de unidades (por ejemplo, longitud, peso, temperatura) en la que desea realizar la conversión.
2. Selección de unidades: Una vez que el usuario elija una categoría, la aplicación debe mostrar las unidades disponibles en esa categoría (por ejemplo, metros, pies, pulgadas para la categoría de longitud) y permitir al usuario seleccionar las unidades de conversión.
3. Entrada de valor: El usuario debe ingresar el valor que desea convertir.
4. Realización de la conversión: La aplicación realizará la conversión de unidades según la fórmula correspondiente y mostrará el resultado al usuario.
5. Opción para volver al menú: Después de cada conversión, la aplicación debe ofrecer al usuario la opción de realizar otra conversión o volver al menú principal.

## Ejemplo de flujo de trabajo:

1. La aplicación muestra un menú de opciones:
```text
Convertidor de Unidades
1. Longitud
2. Peso
3. Temperatura
4. Velocidad
5. Salir
Seleccione una categoría de unidades:

```

2. El usuario elige "Longitud" y ve las unidades disponibles:
```text
Seleccione las unidades de longitud:
1. Metros
2. Pies
3. Pulgadas

```

3. El usuario elige "Metros" y "Pies" como unidades de conversión, luego ingresa el valor a convertir, por ejemplo, "5".
4. La aplicación realiza la conversión y muestra el resultado:
```text
5 metros son aproximadamente 16.4042 pies.

```
5. La aplicación pregunta al usuario si desea realizar otra conversión o volver al menú principal.

## Requisitos adicionales:
* Manejo de errores: Debes manejar posibles errores, como la elección de opciones inválidas o la entrada de valores no numéricos.
* Implementación de múltiples categorías de unidades: Puedes permitir que el usuario elija entre varias categorías de unidades, como longitud, peso, temperatura, velocidad, tiempo, etc.

## Ejecución desde la línea de comandos:

```shell
mvn compile exec:java -Dexec.mainClass="com.apuntesdejava.chatgptchallenge.conversormeasures.MeasurementConverterMain"
```