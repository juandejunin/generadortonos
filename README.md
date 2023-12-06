# Generador de Tonos en Java

Este proyecto es un simple generador de tonos en Java que utiliza la biblioteca `javax.sound.sampled` para reproducir tonos de frecuencias específicas durante un tiempo determinado. Puede ser utilizado como base para aplicaciones que requieran la generación de tonos para propósitos educativos, experimentales o de entretenimiento.

## Uso

1. Clona el repositorio o descarga el código fuente.
2. Abre el proyecto en tu entorno de desarrollo Java preferido.
3. Ejecuta la clase `GeneratorTones.java` que contiene el método `main`.
4. Modifica los parámetros de la función `playTone` para generar tonos con diferentes frecuencias y duraciones.

```java
public static void main(String[] args) {
    // Ejemplo: Tono de 110 Hz durante 1 segundo
    playTone(110, 1000);
}
```

## Configuración del Proyecto

Este proyecto utiliza Maven para gestionar las dependencias. Asegúrate de tener Maven instalado y ejecuta el siguiente comando para compilar y ejecutar el proyecto:

´´´
mvn compile exec:java
´´´
## Detalles del Código

GeneratorTones.java: Contiene el método main para ejecutar el generador y la función playTone que reproduce tonos.
playTone(int frequency, int duration): Genera un tono de la frecuencia y duración especificadas utilizando la API javax.sound.sampled.
Dependencias
El proyecto utiliza la biblioteca estándar de Java para el manejo de audio, por lo que no es necesario agregar dependencias externas.

## Contribuciones
Siéntete libre de contribuir al proyecto, ya sea informando problemas, proponiendo mejoras o enviando solicitudes de extracción.