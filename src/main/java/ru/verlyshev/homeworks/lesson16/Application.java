package ru.verlyshev.homeworks.lesson16;

public class Application {
    public static void main(String[] args) {
        var phoneBook = new PhoneBook();
        phoneBook.add("Vasya", "123456");
        phoneBook.add("Vasya", "789");
        System.out.println(phoneBook.containsPhoneNumber("123456"));
        System.out.println(phoneBook.containsPhoneNumber("123454"));

        System.out.println(phoneBook.find("Vasya"));
        System.out.println(phoneBook.find("Vasya2"));

    }
}
