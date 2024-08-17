package ru.verlyshev.homeworks.lesson10;

public abstract class Animal {
    protected String name;
    protected double moveSpeed;
    protected double swimSpeed;
    protected int swimRatio;
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
            stamina = 0;
            showTired();
            return -1;
        } else {
            stamina = staminaAfterRun;
            var runningTime = distance / moveSpeed;
            System.out.println(name + " пробежал дистанцию " + distance + " за время " + runningTime);
            return runningTime;
        }
    }

    public double swim(int distance) {
        var staminaAfterSwim = stamina - distance * swimRatio;
        if (isTired || staminaAfterSwim < 0) {
            isTired = true;
            stamina = 0;
            showTired();
            return -1;
        } else {
            stamina = staminaAfterSwim;
            var swimTime = distance / swimSpeed;
            System.out.println(name + " проплыл дистанцию за время " + swimTime);
            return swimTime;
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
}
