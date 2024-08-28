package ru.verlyshev.homeworks.lesson16;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private final Map<String, Set<String>> phoneBook = new HashMap<>();

    public void add(String name, String phoneNumber) {
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, new HashSet<>());
        }

        phoneBook.get(name).add(phoneNumber);
    }

    public Set<String> find(String name) {
        if (phoneBook.containsKey(name)) {
            return phoneBook.get(name);
        }

        return new HashSet<>();
    }

    public boolean containsPhoneNumber(String phoneNumber) {
        return !phoneBook.entrySet().stream().filter(entry -> entry.getValue().contains(phoneNumber)).toList().isEmpty();
    }
}
