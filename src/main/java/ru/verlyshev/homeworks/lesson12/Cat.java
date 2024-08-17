package ru.verlyshev.homeworks.lesson12;

public class Cat {
    private String name;
    private int appetite;
    private boolean isWellFed;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        isWellFed = false;
    }

    public void eat(Plate plate) {
        if (plate.reduceFood(appetite)) {
            isWellFed = true;
        }
    }

    public void showInfo() {
        System.out.println(isWellFed ? name + " сытый" : name + " голодный");
    }
}
