package ru.verlyshev.homeworks.lesson12;

public class Plate {
    private int currentFoodAmount;
    private int maxFoodAmount;

    public Plate(int maxFoodAmount) {
        this.maxFoodAmount = maxFoodAmount;
        currentFoodAmount = maxFoodAmount;
    }

    public void addFood(int addFoodAmount) {
        currentFoodAmount = Math.min(maxFoodAmount, (currentFoodAmount + addFoodAmount));
    }

    public boolean reduceFood(int reduceFoodAmount) {
        if (currentFoodAmount < reduceFoodAmount) {
            return false;
        }

        currentFoodAmount -= reduceFoodAmount;
        return true;
    }

}
