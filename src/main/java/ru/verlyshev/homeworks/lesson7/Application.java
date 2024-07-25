package ru.verlyshev.homeworks.lesson7;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        var arr1 = new int[][]{{-1, -1, 2}, {0, 1, -3}};
        System.out.println(sumOfPositiveElements(arr1));
        showSquare(5);
        showSquare(1);
        var arr2 = new int[][]{{1, 1, 3}};
        var arr3 = new int[][]{{1, 2, 3}, {2, 23}};
        System.out.println(getSumOfSecondString(arr2));
        System.out.println(getSumOfSecondString(arr3));
        var arr4 = new int[][]{{1, 2, 3}, {2, 2, 2}, {1, 1, 1}};
        zeroDiagonalElements(arr4);
        System.out.println(Arrays.deepToString(arr4));
        var arr5 = new int[][]{{1, 100, 4}, {0, -2, 201}};
        System.out.println(findMax(arr5));
    }

    static int sumOfPositiveElements(int[][] arr) {
        var sum = 0;

        for (var ints : arr) {
            for (int value : ints) {
                if (value > 0) {
                    sum += value;
                }
            }
        }

        return sum;
    }

    static void showSquare(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    static void zeroDiagonalElements(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j) {
                    array[i][j] = 0;
                }
            }
        }
    }

    static int findMax(int[][] array) {
        var maxValue = array[0][0];

        for (var element : array) {
            for (var value : element) {
                if (maxValue < value) {
                    maxValue = value;
                }
            }
        }

        return maxValue;
    }

    static int getSumOfSecondString(int[][] array) {
        if (array.length < 2) {
            return -1;
        }

        var sum = 0;

        for (int i = 0; i < array[1].length; i++) {
            sum += array[1][i];
        }

        return sum;
    }
}
