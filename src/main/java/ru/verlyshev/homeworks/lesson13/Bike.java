package ru.verlyshev.homeworks.lesson13;

public class Bike implements Transport {
    @Override
    public boolean move(int distance, Locality locality) {
        if (locality.equals(Locality.PLAIN) || locality.equals(Locality.DENSE_FOREST)) {
            System.out.println("Велосипед проехал расстояние " + distance);
            return true;
        }

        return false;
    }
}
