package ru.verlyshev.homeworks.lesson10;

public abstract class Animal {
    protected String name;
    protected double moveSpeed;
    protected double swimSpeed;
    protected double stamina;
    protected boolean isTired;

    public Animal(String name, double moveSpeed, double swimSpeed, double stamina) {
        this.name = name;
        this.moveSpeed = moveSpeed;
        this.swimSpeed = swimSpeed;
        this.stamina = stamina;
        this.isTired = false;
    }

    public double run(int distance) {
        var staminaAfterRun = stamina - distance;
        if (isTired || staminaAfterRun < 0) {
            isTired = true;
            showTired();
            return -1;
        } else {
            stamina = staminaAfterRun;
            var runningTime = distance / moveSpeed;
            System.out.println(name + " пробежал дистнацию " + distance + " за время " + runningTime);
            return runningTime;
        }
    }

    protected void showTired() {
        System.out.println(name + " устал");
    }

    protected void info() {
        System.out.println("Имя животного: " + name);
        System.out.println("Скорость бега: " + moveSpeed);
        System.out.println("Скорость плавания " + swimSpeed);
        System.out.println("Текущий запас выносливости: " + stamina);
        if (isTired) {
            System.out.println("Животное устало");
        } else {
            System.out.println("Животное не устало");
        }
    }

    public abstract double swim(int distance);
}
