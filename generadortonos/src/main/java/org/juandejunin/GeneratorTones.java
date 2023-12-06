package org.juandejunin;

import javax.sound.sampled.*;

public class GeneratorTones {
    public static void main(String[] args) {
        playTone(110, 1000);  // Ejemplo: Tono de 110 Hz durante 1 segundo
    }

    /**
     * Reproduce un tono de frecuencia y duración especificadas.
     *
     * @param frequency Frecuencia del tono en hercios (Hz).
     * @param duration  Duración del tono en milisegundos.
     */
    public static void playTone(int frequency, int duration) {
        try {
            // Configuración del formato de audio (44100 Hz, 16 bits, mono, signed, little-endian)
            AudioFormat format = new AudioFormat(44100, 16, 1, true, false);

            // Información sobre el tipo de línea de audio que se va a utilizar (SourceDataLine)
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

            // Obtención de una línea de audio del sistema
            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);

            // Apertura de la línea y comienzo de la reproducción
            line.open(format);
            line.start();

            // Creación de un buffer para almacenar los datos de audio
            byte[] buffer = new byte[44100 * 2];

            // Generación de los datos de audio para el tono deseado
            for (int i = 0; i < duration * 44.1; i++) {
                // Cálculo del ángulo para la onda sinusoidal
                double angle = i / (44100.0 / frequency) * 2.0 * Math.PI;

                // Cálculo del valor de la muestra en formato PCM (pulse-code modulation)
                short sample = (short) (Short.MAX_VALUE * Math.sin(angle));

                // Almacenamiento de la muestra en el buffer (formato little-endian)
                buffer[2 * i] = (byte) (sample & 0xFF);
                buffer[2 * i + 1] = (byte) ((sample >> 8) & 0xFF);
            }

            // Escritura de los datos en la línea de audio
            line.write(buffer, 0, buffer.length);

            // Espera hasta que la línea haya vaciado todos los datos
            line.drain();

            // Cierre de la línea de audio
            line.close();
        } catch (LineUnavailableException e) {
            // Manejo de excepciones en caso de que la línea de audio no esté disponible
            e.printStackTrace();
        }
    }
}
