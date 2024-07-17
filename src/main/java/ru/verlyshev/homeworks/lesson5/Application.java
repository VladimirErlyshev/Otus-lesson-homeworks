package ru.verlyshev.homeworks.lesson5;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Application {
    public static void main(String[] args) {
        var arr1 = new int[]{1, 2, 3, 6, 11};
        var arr2 = new int[]{4, 4, 4, 16};
        showSummaryArray(arr1, arr2);

        var arr3 = new int[]{1, 2, 2, 5};
        var arr4 = new int[]{2, 3};
        showArrayEqualityPoint(arr3);
        showArrayEqualityPoint(arr4);

        var arr5 = new int[]{1, 2, 3, 4};
        var arr6 = new int[]{10, 5, 1};
        showIsElementsOrdering(arr5, true);
        showIsElementsOrdering(arr5, false);
        showIsElementsOrdering(arr6, true);
        showIsElementsOrdering(arr6, false);

        var arr7 = new int[]{8, 1, 1, 3, 2};
        showFlipArray(arr7);
        showFlipArray(new int[]{1});

    }

    static void showSummaryArray(int[]... arrays) {
        var length = Arrays.stream(arrays).max(Comparator.comparing(Array::getLength)).get().length;
        var result = new int[length];

        for (var array : arrays) {
            for (int i = 0; i < array.length; i++) {
                result[i] += array[i];
            }
        }

        System.out.println(Arrays.toString(result));
    }

    static void showArrayEqualityPoint(int[] arr) {
        var result = "Нет точки эквивалентности в массиве";

        if (arr.length < 2) {
            System.out.println(result);
        } else {
            var leftPart = 0;
            var sum = Arrays.stream(arr).sum();
            for (int i = 0; i < arr.length; i++) {
                leftPart += arr[i];
                if (leftPart == sum - leftPart) {
                    result = "Точка находится между элементами " + i + " и " + (i + 1);
                    System.out.println(result);
                    return;
                }
            }

            System.out.println(result);
        }
    }

    static void showIsElementsOrdering(int[] arr, boolean isDescendingOrder) {
        String result = isDescendingOrder ? "Элементы массива идут в порядке убывания" : "Элементы массива идут в порядке возрастания";

        if (isDescendingOrder) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    result = "Элементы массива не идут в порядке убывания";
                    break;
                }
            }
        } else {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    result = "Элементы массива не идут в порядке возрастания";
                    break;
                }
            }
        }

        System.out.println(result);
    }

    static void showFlipArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            var tmp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = tmp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
