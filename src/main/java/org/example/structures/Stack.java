package org.example.structures;


import org.example.BracketUtils.BracketUtils;

import java.util.Arrays;

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


    private static void printStackContents(Stack<Character> stack) {
        System.out.println("Содержимое стека (сверху вниз):");


        Stack<Character> tempStack = new Stack<>();
        int position = 1;


        while (!stack.isEmpty()) {
            Character element = stack.pop();
            System.out.println(position++ + ": " + element);
            tempStack.push(element);
        }


        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
    public void checkStackElems(Stack<Character> bracketStack, String originalText) {
        Stack<Character> openingBrackets = new Stack<>();
        boolean isBalanced = true;

        Stack<Character> tempStack = new Stack<>();
        while (!bracketStack.isEmpty()) {
            tempStack.push(bracketStack.pop());
        }

        while (!tempStack.isEmpty()) {
            char c = tempStack.pop();

            if (BracketUtils.isBracket(c)) {
                if (BracketUtils.isOpeningBracket(c)) {
                    openingBrackets.push(c);
                } else {
                    if (openingBrackets.isEmpty()) {
                        isBalanced = false;
                        break;
                    }
                    char lastOpening = openingBrackets.pop();
                    if (!BracketUtils.isMatchingPair(lastOpening, c)) {
                        isBalanced = false;
                        break;
                    }
                }
            }
        }

        if (!openingBrackets.isEmpty()) {
            isBalanced = false;
        }


        if (isBalanced) {
            System.out.println("Скобки сбалансированы: " + originalText);
        } else {
            System.out.println("Ошибка: скобки не сбалансированы: " + originalText);
        }
    }



}

