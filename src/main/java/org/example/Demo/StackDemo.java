package org.example.Demo;



import java.util.Scanner;

import org.example.BracketUtils.BracketUtils;
import org.example.structures.Stack;



import org.example.structures.Queue;
import org.example.structures.Stack;
import org.example.BracketUtils.BracketUtils;

public class StackDemo {
    public static void main(String[] args) {
        // Демонстрация работы стека
        demonstrateStack();

        // Проверка баланса скобок
        String[] testStrings = {
                "(a + b)",
                "[{()}]",
                "({[}])",
                "((())",
                "][",
                "<html><body></body></html>"
        };

        for (String str : testStrings) {
            System.out.println("Строка: \"" + str + "\"");
            System.out.println("Баланс скобок: " + (checkBracketBalance(str) ? "правильный" : "неправильный"));
            System.out.println();
        }
    }

    public static void demonstrateStack() {
        System.out.println("Демонстрация работы стека:");
        System.out.println("-------------------------");

        Stack<Integer> stack = new Stack<>();

        // Добавляем элементы в стек
        System.out.println("Добавляем элементы 10, 20, 30 в стек:");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        printStackInfo(stack);

        // Просматриваем верхний элемент
        System.out.println("Верхний элемент (peek): " + stack.peek());
        printStackInfo(stack);

        // Извлекаем элементы
        System.out.println("Извлекаем элементы:");
        System.out.println("Извлечено: " + stack.pop());
        printStackInfo(stack);
        System.out.println("Извлечено: " + stack.pop());
        printStackInfo(stack);

        // Добавляем еще элементы
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

        // Пытаемся извлечь из пустого стека
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
        System.out.println("Пуст?: " + stack.isEmpty());
        System.out.println();
    }


}

/*
public class StackDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество строк: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Введите строку #" + (i+1) + ": ");
            String input = scanner.nextLine();
            checkBracketBalance(input);
        }

        demonstrateGenerics();
        scanner.close();
    }

    public static void checkBracketBalance(String str) {

        Stack<Character> bracketStack = new Stack<>();


        boolean balanced = true;
        while (!bracketQueue.isEmpty()) {
            char current = bracketQueue.dequeue();

            if (BracketUtils.isOpeningBracket(current)) {
                bracketStack.push(current);
            } else {
                if (bracketStack.isEmpty()) {
                    balanced = false;
                    break;
                }

                char top = bracketStack.pop();
                if (!BracketUtils.isMatchingPair(top, current)) {
                    balanced = false;
                    break;
                }
            }
        }

        if (!bracketStack.isEmpty()) {
            balanced = false;
        }

        System.out.println("Строка: \"" + str + "\"");
        System.out.println("Баланс скобок: " + (balanced ? "правильный" : "неправильный"));
        System.out.println();
    }

    public static void demonstrateGenerics() {
        System.out.println("\nДемонстрация работы стека и очереди с другими типами данных:");

        Stack<Integer> intStack = new Stack<>();
        Queue<Double> doubleQueue = new Queue<>();

        System.out.println("Добавляем элементы в стек (Integer) и очередь (Double):");
        for (int i = 1; i <= 5; i++) {
            intStack.push(i);
            doubleQueue.enqueue(i * 1.1);
            System.out.println("Добавлено: стек(" + i + "), очередь(" + (i*1.1) + ")");
        }

        System.out.println("\nИзвлекаем элементы из стека (LIFO):");
        while (!intStack.isEmpty()) {
            System.out.println("Извлечено из стека: " + intStack.pop());
        }

        System.out.println("\nИзвлекаем элементы из очереди (FIFO):");
        while (!doubleQueue.isEmpty()) {
            System.out.println("Извлечено из очереди: " + doubleQueue.dequeue());
        }
    }
}


 */
