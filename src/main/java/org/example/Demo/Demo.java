package org.example.Demo;

import org.example.structures.Queue;

import org.example.Entities.StringObject;
import org.example.structures.Stack;

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
    private static void printStackContents(Stack<Integer> stack) {
        System.out.println("Содержимое стека (сверху вниз):");


        Stack<Integer> tempStack = new Stack<>();
        int position = 1;


        while (!stack.isEmpty()) {
            Integer element = stack.pop();
            System.out.println(position++ + ": " + element);
            tempStack.push(element);
        }


        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
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
System.out.println("Выбранный элемент очереди (dequeue):" +itemQueue.getText());
printQueueContents(queue);

        StringObject itemQueuePeek = queue.peek();
        System.out.println("Извлеченный элемент (peek):" +itemQueuePeek.getText());
        printQueueContents(queue);


        queue.checkQueueElems();



        //  printStructuresWork();




    }


    private static void printStructuresWork() {
        System.out.println("Принцип работы стека:");
        Stack<Integer> testStack = new Stack<>();
        testStack.push(1311);
        testStack.push(2241);
        testStack.push(3241);
        testStack.push(4141);
        System.out.println("Pop stack:"+ testStack.pop());
        printStackContents(testStack);
        System.out.println("Peek stack:"+ testStack.peek());
        printStackContents(testStack);
        System.out.println("Принцип работы очереди:");
        Queue<Integer> testQueue = new Queue<>();

        testQueue.enqueue(323);
        testQueue.enqueue(4322);
        testQueue.enqueue(31);
        System.out.println("Decueue stack:"+ testQueue.peek());
   //     printQueueContents(testQueue);

    }

}