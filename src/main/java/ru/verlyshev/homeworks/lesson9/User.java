package ru.verlyshev.homeworks.lesson9;

import java.time.Year;

class User {
    private final String name;
    private final String surname;
    private final String lastName;
    private final String birthYear;
    private final String email;

    public User(String surname, String name, String patronymic, String birthYear, String email) {
        this.surname = surname;
        this.name = name;
        this.lastName = patronymic;
        this.birthYear = birthYear;
        this.email = email;
    }

    public void showInfo() {
        System.out.println("ФИО: " + surname + " " + name + " " + lastName);
        System.out.println("Год рождения: " + birthYear);
        System.out.println("e-mail " + email);
        System.out.println();
    }

    public int getAge() {
        var currentYear = Year.now();
        return Integer.parseInt(currentYear.toString()) - Integer.parseInt(birthYear);
    }
}
