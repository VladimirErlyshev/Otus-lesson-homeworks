package ru.verlyshev.homeworks.lesson22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysData {
    public int[] getNumbersAfterLast1(int[] numbers) {
        var numbersAsList = Arrays.stream(numbers).boxed().toList();
        if (!numbersAsList.contains(1)) {
            throw new RuntimeException("В массиве нет единиц!");
        }

        var indexOfLast1 = numbersAsList.lastIndexOf(1);
        if (indexOfLast1 == numbers.length - 1) {
            return new int[0];
        }

        return Arrays.copyOfRange(numbers, indexOfLast1 + 1, numbers.length);
    }

    public boolean isArrayConsistsOnlyOf1and2(int[] numbers) {
        if (numbers.length < 2) {
            return false;
        }

        var numbersAsList = new ArrayList<>(Arrays.stream(numbers).boxed().toList());
        if (numbersAsList.contains(1) && numbersAsList.contains(2)) {
            numbersAsList.removeAll(List.of(1, 2));

            return numbersAsList.isEmpty();
        }

        return false;
    }
}
