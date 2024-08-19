package ru.verlyshev.homeworks.lesson13;

public class Human {
    private String name;
    private Transport currentTransport;

    public Human(String name, Transport currentTransport) {
        this.name = name;
        this.currentTransport = currentTransport;
    }

    public void takeTransport(Transport transport) {
        currentTransport = transport;

        if (transport.getClass().equals(Car.class)) {
            System.out.println("Человек сел в машину");
        } else if (transport.getClass().equals(Horse.class)) {
            System.out.println("Человек сел на лошадь");
        } else if (transport.getClass().equals(Bike.class)) {
            System.out.println("Человек сел на велосипед");
        }
    }

    public void getOutOfTransport() {
        if (currentTransport.getClass().equals(Car.class)) {
            System.out.println("Человек вышел из машины");
        } else if (currentTransport.getClass().equals(Horse.class)) {
            System.out.println("Человек слез с лошади");
        } else if (currentTransport.getClass().equals(Bike.class)) {
            System.out.println("Человек слез с велосипеда");
        }

        currentTransport = null;
    }

    public boolean move(int distance, Locality locality) {
        if (currentTransport == null) {
            System.out.println("Человек прошел пешком расстояние " + distance);
            return true;
        } else {
            return currentTransport.move(distance, locality);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
