package ru.verlyshev.homeworks.lesson13;

public class Car implements Transport {
    private int petrolAmount;

    public Car(int petrolAmount) {
        this.petrolAmount = petrolAmount;
    }

    @Override
    public boolean move(int distance, Locality locality) {
        if (locality.equals(Locality.PLAIN) && petrolAmount > distance) {
            System.out.println("Машина проехала расстояние " + distance);
            petrolAmount -= distance;
            return true;
        }

        System.out.println("Машина не смогла проехать указанное расстояние");
        return false;
    }

    public int getPetrolAmount() {
        return petrolAmount;
    }

    public void setPetrolAmount(int petrolAmount) {
        this.petrolAmount = petrolAmount;
    }
}
