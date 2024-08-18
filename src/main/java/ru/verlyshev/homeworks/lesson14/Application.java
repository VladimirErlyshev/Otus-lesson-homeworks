package ru.verlyshev.homeworks.lesson14;

import ru.verlyshev.homeworks.lesson14.exceptions.AppArrayDataException;
import ru.verlyshev.homeworks.lesson14.exceptions.AppArraySizeException;

public class Application {
    public static void main(String[] args) {
        var okArr = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        try {
            System.out.println(getArraySum(okArr));
        } catch (AppArraySizeException | AppArrayDataException e) {
            System.out.println(e.getMessage());
        }

        var incorrectSizeArr = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3"},
                {"1", "2", "3", "4"}
        };

        try {
            System.out.println(getArraySum(incorrectSizeArr));
        } catch (AppArraySizeException | AppArrayDataException e) {
            System.out.println(e.getMessage());
        }

        var illegalDataArr = new String[][] {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "z", "4"}
        };

        try {
            System.out.println(getArraySum(illegalDataArr));
        } catch (AppArraySizeException | AppArrayDataException e) {
            System.out.println(e.getMessage());
        }

    }

    static int getArraySum(String[]... arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4 || arr.length != 4) {
                throw new AppArraySizeException("Массив должен иметь размер 4x4");
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    var element = Integer.parseInt(arr[i][j]);
                    sum += element;
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException("Некорректные данные в ячейке " + i + j);
                }

            }
        }

        return sum;
    }
}
