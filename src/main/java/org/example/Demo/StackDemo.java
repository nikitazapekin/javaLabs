package org.example.Demo;



import java.util.Scanner;

import org.example.BracketUtils.BracketUtils;
import org.example.structures.Stack;



public class StackDemo {


    public static void main(String[] args) {
          Stack<Integer> stack = new Stack<>();

        System.out.println("Демонстрация работы стека:");
        System.out.println("-------------------------");




        System.out.println("Добавляем элементы 10, 20, 30 в стек:");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        printStackInfo(stack);

        System.out.println("Верхний элемент (peek): " + stack.peek());
        printStackInfo(stack);

        System.out.println("Извлекаем элементы:");
        System.out.println("Извлечено: " + stack.pop());
        printStackInfo(stack);
        System.out.println("Извлечено: " + stack.pop());
        printStackInfo(stack);


        System.out.println("Добавляем элементы 40, 50:");
        stack.push(40);
        stack.push(50);
        printStackInfo(stack);

        // Извлекаем все элементы
        System.out.println("Извлекаем все элементы:");
        while (!stack.isEmpty()) {
            System.out.println("Извлечено: " + stack.pop());
            printStackInfo(stack);
        }

        try {
            System.out.println("Пытаемся извлечь из пустого стека:");
            stack.pop();
        } catch (IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n");


    }


    private static void printStackInfo(Stack<?> stack) {
        System.out.println("Содержимое стека: " + stack);
        System.out.println("Размер стека: " + stack.size());
        System.out.println("Пуст: " + stack.isEmpty());
        System.out.println();
    }


}
