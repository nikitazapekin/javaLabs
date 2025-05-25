package org.example;

import org.example.helpers.sortMethods;
import java.util.Arrays;
import java.util.Comparator;

public class Lab11Zadanie1 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Не переданы аргументы командной строки.");
            return;
        }

        System.out.println("Исходный массив:");
        printArray(args);


        String substring = "S";
        String[] sortedBySubstring = sortArray(args, sortMethods.bySubstringPosition(substring),
                "по позиции первого вхождения '" + substring + "'");

        String[] sortedByLowerCase = sortArray(args, sortMethods.byLowerCaseCount(),
                "по количеству маленьких букв");

    }

    private static String[] sortArray(String[] array, Comparator<String> comparator, String description) {
        String[] sortedArray = Arrays.copyOf(array, array.length);
        sortMethods.comparisonCount = 0;
        Arrays.sort(sortedArray, comparator);

        System.out.println("\nМассив после сортировки " + description + ":");
        printArray(sortedArray);
        System.out.println("Количество операций сравнения: " + sortMethods.comparisonCount);

        return sortedArray;
    }
    private static void printArray(String[] array) {
        for (String s : array) {
            System.out.println(s);
        }
    }
}