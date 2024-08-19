package ru.verlyshev.homeworks.lesson13;

public class Application {
    public static void main(String[] args) {
        var human = new Human("Вася", new Car(5));
        human.move(1, Locality.PLAIN);
        human.move(1, Locality.SWAMP);
        human.getOutOfTransport();
        human.move(4, Locality.DENSE_FOREST);
        human.takeTransport(new Horse(10));
        human.move(11, Locality.PLAIN);
        human.move(2, Locality.PLAIN);
    }
}
