package org.example.Demo;

import org.example.structures.Queue;

import org.example.Entities.StringObject;
public class Demo {
    private static void printQueueContents(Queue<StringObject> queue) {
        System.out.println("Содержимое очереди:");
        Queue<StringObject> tempQueue = new Queue<StringObject>();
        int position = 1;
        while (!queue.isEmpty()) {
            StringObject element = queue.dequeue();
            System.out.println(position++ + ": " + element.getText());
            tempQueue.enqueue(element);
        }

        while (!tempQueue.isEmpty()) {
            queue.enqueue(tempQueue.dequeue());
        }
    }

    public static void main(String[] args) {
        Queue<StringObject> queue = new Queue<StringObject>();
        queue.enqueue(new StringObject("(a + b)"));
        queue.enqueue(new StringObject("[{()}]"));
        queue.enqueue(new StringObject("({[}])"));
        queue.enqueue(new StringObject("]["));
        queue.enqueue(new StringObject("<html><body></body></html>"));


        printQueueContents(queue);


        queue.enqueue(new StringObject("Тест 1"));
        printQueueContents(queue);
StringObject itemQueue = queue.dequeue();
System.out.println("Selected item queue (dequeue):" +itemQueue.getText());
printQueueContents(queue);

        StringObject itemQueuePeek = queue.peek();
        System.out.println("Selected item queue (peek):" +itemQueuePeek.getText());
        printQueueContents(queue);


        queue.checkQueueElems();
    }

}
/*
import org.example.structures.Stack;

import org.example.Entities.StringObject;

public class StackDemo {


    public static void main(String[] args) {
          Stack<StringObject> stack = new Stack<>();

        System.out.println("Демонстрация работы стека:");
        System.out.println("-------------------------");
        printStackInfo(stack);

stack.push(new StringObject("(a + b)"));
        stack.push(new StringObject("[{()}]"));
        stack.push(new StringObject("[{()}]"));
        stack.push(new StringObject("((())"));
        stack.push(new StringObject("]["));
        stack.push(new StringObject("<html><body></body></html>"));


        printStackInfo(stack);

        System.out.println("Верхний элемент (peek): " + stack.peek().getText());
        printStackInfo(stack);

        System.out.println("Извлекаем элементы:");
        System.out.println("Извлечено: " + stack.pop().getText());
        printStackInfo(stack);
        System.out.println("Извлечено: " + stack.pop().getText());


        System.out.println("Извлекаем все элементы:");
        while (!stack.isEmpty()) {
            System.out.println("Извлечено: " + stack.pop().getText());
            printStackInfo(stack);
        }

        try {
            System.out.println("Пытаемся извлечь из пустого стека:");
            stack.pop().getText();
        } catch (IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }




    }
private void checkIdentity() {
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
        System.out.println("Баланс скобок: " + (Stack.checkBracketBalance(str) ? "правильный" : "неправильный"));
        System.out.println();
    }
}

    private static void printStackInfo(Stack<?> stack) {
        System.out.println("Содержимое стека: ");
        System.out.println("Размер стека: " + stack.size());
        System.out.println("Пуст: " + stack.isEmpty());
        System.out.println();
    }


}
*/