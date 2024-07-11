/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package patron.creacional.factory.method;

/**
 *
 * @author Melvin Prendas
 */
/* Problema a resolver:
Necesitamos crear objetos sin especificar la clase exacta del objeto que se creará. 
Esto es útil cuando la creación de los objetos es compleja o cuando la decisión de qué clase instanciar se toma en tiempo de ejecución.

Implementación:
Vamos a implementar el patrón Factory Method para la creación de vehículos. 
Dependiendo del tipo de vehículo que se desee, el método de fábrica correspondiente se encargará de la creación. */

// Interfaz del Producto
interface Vehicle {
    void drive();
}

// Productos Concretos
class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Manejando un carro.");
    }
}

class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Manejando una bicicleta.");
    }
}

// Clase Fábrica Abstracta
abstract class VehicleFactory {
    public abstract Vehicle createVehicle();
}

// Clases Fábrica Concretas
class CarFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}

class BikeFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Bike();
    }
}

// Cliente
public class FactoryMethod {
    public static void main(String[] args) {
        VehicleFactory factory = new CarFactory();
        Vehicle vehicle = factory.createVehicle();
        vehicle.drive();

        factory = new BikeFactory();
        vehicle = factory.createVehicle();
        vehicle.drive();
    }
}
