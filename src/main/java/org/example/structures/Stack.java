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


        Stack<Character> tempStack = new Stack<>();
        boolean balanced = true;


        Object[] copy = new Object[elements.length];
        System.arraycopy(elements, 0, copy, 0, top + 1);

        try {
            for (int i = 0; i <= top; i++) {
                char c = (Character) copy[i];

                if (BracketUtils.isOpeningBracket(c)) {
                    tempStack.push(c);
                } else {
                    if (tempStack.isEmpty()) {
                        balanced = false;
                        break;
                    }

                    char last = tempStack.pop();
                    if (!BracketUtils.isMatchingPair(last, c)) {
                        balanced = false;
                        break;
                    }
                }
            }
            balanced = balanced && tempStack.isEmpty();
            System.out.println("Строка: \"" + originalText + "\" - " +
                    (balanced ? "скобки сбалансированы" : "скобки НЕ сбалансированы"));
        } catch (ClassCastException e) {
            System.out.println("Ошибка: стек содержит не символьные данные");
        }
    }

  /*  private boolean isOpeningBracket(char c) {
        return c == '(' || c == '[' || c == '{' || c == '<';
    }

    private boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
                (opening == '[' && closing == ']') ||
                (opening == '{' && closing == '}') ||
                (opening == '<' && closing == '>');
    }

   */


}

/*
import org.example.BracketUtils.BracketUtils;

public class Stack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public Stack() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void push(T item) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = item;
    }


    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        T item = (T) elements[--size];
        elements[size] = null;
        return item;
    }


    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        return (T) elements[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize() {
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }



    public static void checkBracketBalance(String str) {


    }


}
*/