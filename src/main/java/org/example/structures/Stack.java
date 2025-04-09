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

/*
    public void checkStackElems(String originalText) {
        if (isEmpty()) {
            System.out.println("Стек пуст - строка: \"" + originalText + "\"");
            return;
        }

        // Создаем временные стеки для проверки
        Stack<Character> tempStack1 = new Stack<>();
        Stack<Character> tempStack2 = new Stack<>();
        boolean isIdentical = true;

        while (!this.isEmpty()) {
     //       tempStack1.push(elements.pop());
        }

    }


 */

    /*
public void checkStackElems(String originalText) {
    if (isEmpty()) {
        System.out.println("Стек пуст - строка: \"" + originalText + "\"");
        return;
    }

    Stack<Character> tempStack1 = new Stack<>();
    Stack<Character> tempStack2 = new Stack<>();
    boolean isIdentical = true;
    int index = 0;


    while (!this.isEmpty()) {
        tempStack1.push((Character)this.pop());
    }

    while (!tempStack1.isEmpty()) {
        char stackChar = tempStack1.peek();

        if (index >= originalText.length()) {
            isIdentical = false;
            break;
        }

        char stringChar = originalText.charAt(index++);

        if (stackChar != stringChar) {
            isIdentical = false;
        }

        tempStack2.push(tempStack1.pop());
    }

    if (index != originalText.length()) {
        isIdentical = false;
    }

    while (!tempStack2.isEmpty()) {
        this.push((T)tempStack2.pop());
    }

    System.out.println("Строка: \"" + originalText + "\" - " +
            (isIdentical ? "идентична содержимому стека" : "НЕ идентична содержимому стека"));
}

     */
    public void checkStackElems(String originalText) {
        if (isEmpty()) {
            System.out.println("Стек пуст - строка: \"" + originalText + "\"");
            return;
        }

        Stack<Character> bracketStack = new Stack<>();
        boolean isBalanced = true;

        // Сначала проверим, что в стеке только скобки
        Stack<Character> tempStack = new Stack<>();
        while (!this.isEmpty()) {
            char c = (Character)this.pop();
            tempStack.push(c);
            if (!BracketUtils.isBracket(c)) {
                isBalanced = false;
            }
        }

        // Вернем элементы обратно в исходный стек
        while (!tempStack.isEmpty()) {
            this.push((T)tempStack.pop());
        }

        if (!isBalanced) {
            System.out.println("Строка: \"" + originalText + "\" - содержит не только скобки");
            return;
        }

        // Теперь проверим баланс скобок
        Stack<Character> checkStack = new Stack<>();
        tempStack = new Stack<>();

        while (!this.isEmpty()) {
            char c = (Character)this.pop();
            tempStack.push(c);

            if (BracketUtils.isOpeningBracket(c)) {
                checkStack.push(c);
            } else if (BracketUtils.isClosingBracket(c)) {
                if (checkStack.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char top = checkStack.pop();
                if (!BracketUtils.isMatchingPair(top, c)) {
                    isBalanced = false;
                    break;
                }
            }
        }

        // Проверяем, что все открытые скобки были закрыты
        isBalanced = isBalanced && checkStack.isEmpty();

        // Восстанавливаем исходный стек
        while (!tempStack.isEmpty()) {
            this.push((T)tempStack.pop());
        }

        System.out.println("Строка: \"" + originalText + "\" - " +
                (isBalanced ? "скобки сбалансированы" : "скобки НЕ сбалансированы"));
    }




}

