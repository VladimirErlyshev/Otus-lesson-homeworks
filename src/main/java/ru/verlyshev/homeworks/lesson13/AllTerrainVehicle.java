package ru.verlyshev.homeworks.lesson13;

public class AllTerrainVehicle implements Transport {
    private int petrolAmount;

    public AllTerrainVehicle(int petrolAmount) {
        this.petrolAmount = petrolAmount;
    }

    @Override
    public boolean move(int distance, Locality locality) {
        if (petrolAmount > distance) {
            System.out.println("Вездеход проехал расстояние " + distance);
            return true;
        } else {
            System.out.println("Вездеход не смог проехать указанное расстояние");
            return false;
        }
    }

    public int getPetrolAmount() {
        return petrolAmount;
    }

    public void setPetrolAmount(int petrolAmount) {
        this.petrolAmount = petrolAmount;
    }
}
