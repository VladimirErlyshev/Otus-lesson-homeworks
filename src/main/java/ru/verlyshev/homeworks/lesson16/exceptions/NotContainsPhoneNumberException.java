package ru.verlyshev.homeworks.lesson16.exceptions;

public class NotContainsPhoneNumberException extends RuntimeException{
    public NotContainsPhoneNumberException(String message) {
        super(message);
    }
}
