package ru.verlyshev.homeworks.lesson13;

public class Horse implements Transport {
    private int power;

    public Horse(int power) {
        this.power = power;
    }

    @Override
    public boolean move(int distance, Locality locality) {
        if (locality.equals(Locality.DENSE_FOREST) && power > distance * 2) {
            System.out.println("Лошадь прошла расстояние " + distance);
            return true;
        } else if (locality.equals(Locality.PLAIN) && power > distance) {
            System.out.println("Лошадь прошла расстояние " + distance);
            return true;
        } else {
            System.out.println("Лошадь не прошла указанную дистанцию");
            return false;
        }
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
