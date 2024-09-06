package ru.verlyshev.homeworks.lesson11;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        var personDb = new PersonDataBase(new ArrayList<>());
        var person1 = new Person("Vasya", Position.DIRECTOR, 1L);
        var person2 = new Person("Petya", Position.DRIVER, 2L);
        personDb.add(person1);
        personDb.add(person2);

        personDb.add(new Person("Katya", Position.JANITOR, 3L));
        var person4 = new Person("Jenya", Position.DEVELOPER, 4L);
        personDb.add(person4);
        System.out.println(personDb.findById(1L).toString());
        System.out.println(personDb.isEmployee(1L));
        System.out.println(personDb.isManager(personDb.getPersons().get(0)));
    }
}
