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