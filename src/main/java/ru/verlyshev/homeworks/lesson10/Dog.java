package ru.verlyshev.homeworks.lesson10;

public class Dog extends Animal {
    public Dog(String name, double moveSpeed, double swimSpeed, double stamina) {
        super(name, moveSpeed, swimSpeed, stamina);
        swimRatio = 2;
    }
}
