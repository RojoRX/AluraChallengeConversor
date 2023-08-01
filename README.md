# Conversor de Moneda y Tiempo

Este es un programa en Java que implementa un conversor de moneda y tiempo. Permite al usuario convertir valores entre diferentes unidades de moneda y tiempo.

## Funcionalidades

El programa tiene las siguientes funcionalidades:

### Conversor de Moneda

- Convierte el valor de una moneda a otra seleccionada por el usuario.
- Utiliza tasas de cambio fijas para realizar las conversiones (pueden ser modificadas en el código).
- Muestra el resultado de la conversión en una ventana emergente.

### Conversor de Tiempo

- Convierte un valor de tiempo de una unidad a otra seleccionada por el usuario.
- Admite conversiones entre segundos, minutos, horas, días, semanas, meses y años.
- Muestra el resultado de la conversión en una ventana emergente.

## Requisitos

Para ejecutar este programa, necesitarás tener instalado lo siguiente en tu sistema:

- Java Development Kit (JDK) 8 o superior.
- Un entorno de desarrollo integrado (IDE) compatible con Java, como Eclipse, IntelliJ IDEA o NetBeans (opcional).

## Instrucciones de uso

1. Clona este repositorio en tu computadora o descarga los archivos como un archivo ZIP.
2. Abre el proyecto en tu IDE si lo deseas o simplemente navega a la ubicación del archivo `Main.java`.
3. Ejecuta el archivo `Main.java` para abrir el menú principal.
4. Desde el menú principal, puedes seleccionar entre las siguientes opciones:
   - **Conversor de Moneda:** Permite convertir valores de moneda entre diferentes monedas.
   - **Conversor de Tiempo:** Permite convertir valores de tiempo entre diferentes unidades de tiempo.
   - **Salir del Programa:** Cierra la aplicación.

## Configuración

### Conversor de Moneda

Para modificar las tasas de cambio para el conversor de moneda, abre la clase `CurrencyConverter` en el paquete `model` y busca el método `convertCurrency`.

Dentro de este método, encontrarás un mapa llamado `exchangeRates` que almacena las tasas de cambio. Puedes modificar las tasas o agregar nuevas monedas según sea necesario.

### Conversor de Tiempo

El conversor de tiempo admite conversiones entre las siguientes unidades de tiempo: segundos, minutos, horas, días, semanas, meses y años. No requiere configuración adicional.

## Desarrollador

Este programa fue desarrollado por Eric Rojo como parte de un desafío técnico de programación backEnd.
