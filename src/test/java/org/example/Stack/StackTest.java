package org.example.Stack;


import org.example.structures.Stack;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StackTest {

    private Stack<Integer> intStack;
    private Stack<String> stringStack;
    private Stack<Character> charStack;

    @BeforeAll
    static void beforeAll() {
        System.out.println("[BeforeAll] Выполняется перед всеми тестами");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("[AfterAll] Выполняется после всех тестов");
    }

    @BeforeEach
    void beforeEach() {
        intStack = new Stack<>();
        stringStack = new Stack<>();
        charStack = new Stack<>();
        System.out.println("[BeforeEach] Выполняется перед каждым тестом");
    }

    @AfterEach
    void afterEach() {
        System.out.println("[AfterEach] Выполняется после каждого теста");
    }

    @Test
    void testStackCreation() {
        assertNotNull(intStack, "Стек не должен быть null");
        assertTrue(intStack.isEmpty(), "Новый стек должен быть пустым");
    }

    @Test
    void testPushAndPeek() {
        intStack.push(10);
        assertFalse(intStack.isEmpty(), "Стек не должен быть пустым после добавления элемента");
        assertEquals(10, intStack.peek(), "Вершина стека должна быть равна последнему добавленному элементу");
    }

    @Test
    void testPop() {
        intStack.push(20);
        intStack.push(30);
        assertEquals(30, intStack.pop(), "Метод pop должен возвращать последний добавленный элемент");
        assertEquals(20, intStack.peek(), "После pop вершина стека должна быть предыдущим элементом");
    }

    @Test
    void testPopEmptyStack() {
        assertThrows(IllegalStateException.class, () -> intStack.pop(),
                "Попытка pop из пустого стека должна вызывать исключение");
    }

    @Test
    void testPeekEmptyStack() {
        assertThrows(IllegalStateException.class, () -> intStack.peek(),
                "Попытка peek в пустом стеке должна вызывать исключение");
    }

    @Test
    void testSize() {
        assertEquals(0, intStack.size(), "Размер пустого стека должен быть 0");
        intStack.push(1);
        intStack.push(2);
        assertEquals(2, intStack.size(), "Размер стека должен соответствовать количеству добавленных элементов");
    }

    @Test
    void testResize() {
        Stack<Integer> smallStack = new Stack<>(2);
        smallStack.push(1);
        smallStack.push(2);
        smallStack.push(3);
        assertEquals(3, smallStack.size(), "После resize стек должен содержать все элементы");
        assertEquals(3, smallStack.peek(), "Вершина стека после resize должна быть корректной");
    }

    @Test
    void testInitialCapacityValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Stack<>(0),
                "Создание стека с capacity <= 0 должно вызывать исключение");
        assertThrows(IllegalArgumentException.class, () -> new Stack<>(-1),
                "Создание стека с отрицательным capacity должно вызывать исключение");
    }

    @Test
    void testCheckStackElemsWithBalancedBrackets() {
        charStack.push('(');
        charStack.push(')');
        charStack.push('{');
        charStack.push('}');
        charStack.checkStackElems("test");

    }

    @Test
    void testCheckStackElemsWithUnbalancedBrackets() {
        charStack.push('(');
        charStack.push('{');
        charStack.push(')');
        charStack.checkStackElems("test");

    }

    @Test
    void testCheckStackElemsWithNoBrackets() {
        charStack.push('a');
        charStack.push('b');
        charStack.push('c');
        charStack.checkStackElems("test");
        // Проверка для стека без скобок
    }

    @Test
    void testCheckStackElemsWithNonCharElements() {
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        intStack.checkStackElems("test");

    }

    @Test
    void testStackWithStrings() {
        stringStack.push("first");
        stringStack.push("second");
        assertEquals("second", stringStack.pop());
        assertEquals("first", stringStack.peek());
    }

    @Test
    void testMultipleTypes() {
        Stack<Object> objectStack = new Stack<>();
        objectStack.push("string");
        objectStack.push(123);
        objectStack.push(45.67);
        assertEquals(45.67, objectStack.pop());
        assertEquals(123, objectStack.pop());
        assertEquals("string", objectStack.pop());
    }
}