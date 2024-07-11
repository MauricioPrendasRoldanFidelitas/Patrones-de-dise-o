/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package patron.estructural.adapter;

/**
 *
 * @author Melvin Prendas
 */
/* Problema a resolver:
Tenemos una interfaz existente que no es compatible con la interfaz que se espera en el sistema actual. 
El patrón Adapter permite que dos interfaces incompatibles trabajen juntas.

Implementación:
Vamos a implementar el patrón Adapter para conectar un lector de audio con un sistema de reproducción de audio. */

// Interfaz Esperada
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Clase Adaptada
class AdvancedMediaPlayer {
    void playMp3(String fileName) {
        System.out.println("Reproduciendo archivo mp3: " + fileName);
    }

    void playMp4(String fileName) {
        System.out.println("Reproduciendo archivo mp4: " + fileName);
    }
}

// Adaptador
class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("mp3")) {
            advancedMusicPlayer = new AdvancedMediaPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer = new AdvancedMediaPlayer();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            advancedMusicPlayer.playMp3(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}

// Cliente
public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Reproduciendo archivo mp3: " + fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("El formato: " + audioType + " es inválido");
        }
    }

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "cancion.mp3");
        audioPlayer.play("mp4", "pelicula.mp4");
        audioPlayer.play("avi", "miPelicula.avi");
    }
}


