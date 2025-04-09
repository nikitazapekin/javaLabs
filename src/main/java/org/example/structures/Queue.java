package org.example.structures;


import org.example.BracketUtils.BracketUtils;
import org.example.Entities.StringObject;

public class Queue<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T getNext(T item) {
        Node<T> current = front;
        while (current != null && current.next != null) {
            if (current.data.equals(item)) {
                return current.next.data;
            }
            current = current.next;
        }
        return null;
    }


   public void checkQueueElems(T item) {

       String text = ((StringObject) item).getText();
       Stack<Character> bracketStack = new Stack<>();
       //  for (char c : text.toCharArray()) {
       // bracketStack.push(c);
      // }
       bracketStack.checkStackElems(text);
       }


}