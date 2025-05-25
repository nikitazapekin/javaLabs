package org.example;

import org.example.helpers.processString;

public class Lab11Zadanie2 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Не передана входная строка.");
            return;
        }
        String input = String.join(" ", args);
        System.out.println("Исходная строка: " + input);
        String result = processString.appendVowelsCount(input);
        System.out.println("Результат обработки: " + result);
    }
}