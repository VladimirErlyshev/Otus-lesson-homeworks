package ru.verlyshev.homeworks.lesson22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

class ArraysDataTests {
    private ArraysData arraysData;

    @BeforeEach
    void init() {
        arraysData = new ArraysData();
    }

    static Stream<Arguments> testArrayConsistsOnlyOf1and2ReturnFalse() {
        return Stream.of(
                Arguments.of(new int[]{}),
                Arguments.of(new int[]{1}),
                Arguments.of(new int[]{2}),
                Arguments.of(new int[]{9}),
                Arguments.of(new int[]{1, 1}),
                Arguments.of(new int[]{1, 1, 3}),
                Arguments.of(new int[]{1, 2, 3}),
                Arguments.of(new int[]{2, 1, 4}),
                Arguments.of(new int[]{2, 2})
        );
    }

    static Stream<Arguments> testArrayConsistsOnlyOf1and2ReturnTrue() {
        return Stream.of(
                Arguments.of(new int[]{1, 2}),
                Arguments.of(new int[]{2, 1}),
                Arguments.of(new int[]{1, 1, 2}),
                Arguments.of(new int[]{2, 1, 1}));
    }

    static Stream<Arguments> testGetNumbersAfterLast1ThrowEx() {
        return Stream.of(
                Arguments.of(new int[]{}),
                Arguments.of(new int[]{2, 2, 3, 4,})
        );
    }

    static Stream<Arguments> testGetNumbersAfterLast1NonEmptyResult() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1, 2}, new int[]{2}),
                Arguments.of(new int[]{1, 2, 3}, new int[]{2, 3})
        );
    }

    @ParameterizedTest(name = "Метод isArrayConsistsOnlyOf1and2 возвращает false")
    @MethodSource("testArrayConsistsOnlyOf1and2ReturnFalse")
    void arrayConsistsOnlyOf1and2False(int[] numbers) {
        Assertions.assertFalse(arraysData.isArrayConsistsOnlyOf1and2(numbers));
    }

    @ParameterizedTest(name = "Метод isArrayConsistsOnlyOf1and2 возвращает true")
    @MethodSource("testArrayConsistsOnlyOf1and2ReturnTrue")
    void arrayConsistsOnlyOf1and2True(int[] numbers) {
        Assertions.assertTrue(arraysData.isArrayConsistsOnlyOf1and2(numbers));
    }

    @ParameterizedTest(name = "Метод getNumbersAfterLast1 выбрасывает исключение")
    @MethodSource("testGetNumbersAfterLast1ThrowEx")
    void getNumbersAfterLast1ThrowException(int[] numbers) {
        Assertions.assertThrows(RuntimeException.class, () -> arraysData.getNumbersAfterLast1(numbers));
    }

    @ParameterizedTest(name = "Метод getNumbersAfterLast1 возвращает непустой массив")
    @MethodSource("testGetNumbersAfterLast1NonEmptyResult")
    void getNumbersAfterLast1NonEmptyArray(int[] numbers, int[] result) {
        Assertions.assertArrayEquals(arraysData.getNumbersAfterLast1(numbers), result);
    }

    @Test
    @DisplayName("Метод getNumbersAfterLast1 возвращает пустой массив")
    void getNumbersAfterLast1EmptyArray() {
        Assertions.assertArrayEquals(arraysData.getNumbersAfterLast1(new int[]{2, 3, 1}), new int[]{});
    }
}
