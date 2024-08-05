package ru.verlyshev.homeworks.lesson10;

public class Cat extends Animal{
    public Cat(String name, double moveSpeed, double stamina) {
        super(name, moveSpeed, 0, stamina);
    }

    @Override
    public double swim(int distance) {
        System.out.println("Кот плавать не умеет!");
        return -1;
    }
}
