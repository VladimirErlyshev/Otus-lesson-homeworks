package ru.verlyshev.homeworks.lesson16;

import ru.verlyshev.homeworks.lesson16.exceptions.NotContainsPhoneNumberException;

public class Application {
    public static void main(String[] args) {
        var phoneBook = new PhoneBook();
        phoneBook.add("Vasya", "123456");
        phoneBook.add("Vasya", "789");
        System.out.println(phoneBook.containsPhoneNumber("123456"));
        System.out.println(phoneBook.containsPhoneNumber("123454"));
        try {
            System.out.println(phoneBook.find("Vasya"));
        } catch (NotContainsPhoneNumberException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(phoneBook.find("Vasya2"));
        } catch (NotContainsPhoneNumberException e) {
            System.out.println(e.getMessage());
        }

    }
}
