package ru.verlyshev.homeworks.lesson10;

public class Horse extends Animal {
    public Horse(String name, double moveSpeed, double swimSpeed, double stamina) {
        super(name, moveSpeed, swimSpeed, stamina);
        swimRatio = 4;
    }
}
