package ru.verlyshev.homeworks.lesson10;

public class Horse extends Animal {
    public Horse(String name, double moveSpeed, double swimSpeed, double stamina) {
        super(name, moveSpeed, swimSpeed, stamina);
    }

    @Override
    public double swim(int distance) {
        var staminaAfterSwim = stamina - distance * 4;
        if (isTired || staminaAfterSwim < 0) {
            isTired = true;
            showTired();
            return -1;
        } else {
            stamina = staminaAfterSwim;
            var swimTime = distance / swimSpeed;
            System.out.println(name + " проплыл дистацнию за время " + swimTime);
            return swimTime;
        }
    }
}
