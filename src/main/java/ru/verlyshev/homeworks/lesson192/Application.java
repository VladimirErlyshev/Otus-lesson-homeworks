package ru.verlyshev.homeworks.lesson192;

public class Application {
    public static void main(String[] args) {
        var box1 = new Box<Apple>();
        System.out.println(box1.weight());
        box1.add(new Apple());
        System.out.println(box1.weight());
        box1.add(new Apple());
        System.out.println(box1.weight());
        var box2 = new Box<Fruit>();
        box1.shiftFruits(box2);
        System.out.println(box2.weight());
        System.out.println(box1.weight());
        var box3 = new Box<Orange>();
        //box3.shiftFruits(box1); - invalid type

        box1.add(new Apple());
        box1.add(new Apple());
        System.out.println(box1.compare(box2));
        box2.add(new Orange());
        System.out.println(box1.compare(box2));
    }
}
