package org.example.structures;


import org.example.BracketUtils.BracketUtils;

public class Stack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int top;
    private int capacity;

    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    public Stack(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive");
        }
        this.elements = new Object[initialCapacity];
        this.top = -1;
        this.capacity = initialCapacity;
    }

    public void push(T item) {
        if (top == capacity - 1) {
            resize();
        }
        elements[++top] = item;
    }


    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T item = (T) elements[top];
        elements[top--] = null;
        return item;
    }


    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) elements[top];
    }


    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(elements, 0, newArray, 0, capacity);
        elements = newArray;
        capacity = newCapacity;
    }

    public void checkStackElems(String originalText) {
        if (isEmpty()) {
            System.out.println("Строка: \"" + originalText + "\" - нет скобок");
            return;
        }


        boolean balanced = true;

        try {

            Stack<Character> bracketsStack = new Stack<>();
            for (int i = 0; i <= top; i++) {
                char c = (Character) elements[i];
                if (BracketUtils.isBracket(c)) {
                    bracketsStack.push(c);
                }
            }


            Stack<Character> temp = new Stack<>();
            while (!bracketsStack.isEmpty()) {
                char c = bracketsStack.pop();

                if (BracketUtils.isClosingBracket(c)) {
                    temp.push(c);
                } else {
                    if (temp.isEmpty()) {
                        balanced = false;
                        break;
                    }
                    char last = temp.pop();

                    if (!BracketUtils.isMatchingPair(c, last)) {
                        balanced = false;
                        break;
                    }
                }
            }

            balanced = balanced && temp.isEmpty();
            System.out.println("Строка: \"" + originalText + "\" - " + (balanced ? "скобки сбалансированы" : "скобки НЕ сбалансированы"));
        } catch (ClassCastException e) {
            System.out.println("Ошибка: стек содержит не символьные данные");
        }
    }


}

