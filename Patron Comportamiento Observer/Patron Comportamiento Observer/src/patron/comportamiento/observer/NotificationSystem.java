/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package patron.comportamiento.observer;

/**
 *
 * @author Melvin Prendas
 */
/* Problema a resolver:
Necesitamos notificar a múltiples objetos dependientes cuando el estado de un objeto cambie. 
Esto es útil en escenarios como sistemas de notificación, sistemas de eventos, etc.

Implementación:
Vamos a implementar el patrón Observer en un sistema de notificaciones donde múltiples usuarios reciben actualizaciones sobre cambios en un tema. */

import java.util.ArrayList;
import java.util.List;

// Interfaz Observer
interface Observer {
    void update(String message);
}

// Clase Sujeto
class Subject {
    private List<Observer> observers = new ArrayList<>();
    private String message;

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void setMessage(String message) {
        this.message = message;
        notifyObservers();
    }
}

// Clases Observadoras Concretas
class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Usuario " + name + " ha recibido un mensaje: " + message);
    }
}

// Cliente
public class NotificationSystem {
    public static void main(String[] args) {
        Subject topic = new Subject();

        Observer user1 = new User("Alice");
        Observer user2 = new User("Bob");

        topic.attach(user1);
        topic.attach(user2);

        topic.setMessage("Nueva actualización disponible!");

        topic.detach(user1);

        topic.setMessage("Nueva Función Lanzada!");
    }
}
