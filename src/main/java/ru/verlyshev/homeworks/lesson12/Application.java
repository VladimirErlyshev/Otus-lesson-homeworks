package ru.verlyshev.homeworks.lesson12;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        var cats = new Cat[]{
                new Cat("Барсик", 5),
                new Cat("Вася", 10),
                new Cat("Буся", 11),
                new Cat("Ася", 2)
        };

        var plate = new Plate(27);

        Arrays.stream(cats).forEach(cat -> {
            cat.eat(plate);
            cat.showInfo();
        });
    }
}
