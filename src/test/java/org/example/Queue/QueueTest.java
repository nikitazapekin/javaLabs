package org.example.Queue;



import org.example.BracketUtils.BracketUtils;
import org.example.Entities.StringObject;
import org.example.structures.Queue;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class QueueTest {

    private Queue<Integer> intQueue;
    private Queue<String> stringQueue;
    private Queue<StringObject> stringObjectQueue;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Начало тестирования класса Queue");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Завершение тестирования класса Queue");
    }

    @BeforeEach
    void setUp() {
        intQueue = new Queue<>();
        stringQueue = new Queue<>();
        stringObjectQueue = new Queue<>();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Тест завершен");
    }

    @Test
    void testQueueCreation() {
        assertNotNull(intQueue);
        assertTrue(intQueue.isEmpty());
        assertEquals(0, intQueue.size());
    }

    @Test
    void testEnqueueAndPeek() {
        intQueue.enqueue(10);
        assertFalse(intQueue.isEmpty());
        assertEquals(10, intQueue.peek());
        assertEquals(1, intQueue.size());
    }

    @Test
    void testMultipleEnqueue() {
        intQueue.enqueue(10);
        intQueue.enqueue(20);
        intQueue.enqueue(30);

        assertEquals(3, intQueue.size());
        assertEquals(10, intQueue.peek());
    }

    @Test
    void testDequeue() {
        intQueue.enqueue(10);
        intQueue.enqueue(20);

        assertEquals(10, intQueue.dequeue());
        assertEquals(1, intQueue.size());
        assertEquals(20, intQueue.peek());
    }

    @Test
    void testDequeueEmptyQueue() {
        assertThrows(IllegalStateException.class, () -> intQueue.dequeue());
    }

    @Test
    void testPeekEmptyQueue() {
        assertThrows(IllegalStateException.class, () -> intQueue.peek());
    }

    @Test
    void testStringQueue() {
        stringQueue.enqueue("first");
        stringQueue.enqueue("second");

        assertEquals("first", stringQueue.dequeue());
        assertEquals("second", stringQueue.peek());
    }

    @Test
    void testCheckQueueElemsWithEmptyQueue() {
        assertDoesNotThrow(() -> stringObjectQueue.checkQueueElems());
    }

    @Test
    void testCheckQueueElemsWithStringObjects() {
        stringObjectQueue.enqueue(new StringObject("(test)"));
        stringObjectQueue.enqueue(new StringObject("{unbalanced"));
        stringObjectQueue.enqueue(new StringObject("no brackets"));

        assertDoesNotThrow(() -> stringObjectQueue.checkQueueElems());
    }

    @Test
    void testCheckQueueElemsWithNonStringObjects() {
        Queue<Integer> testQueue = new Queue<>();
        testQueue.enqueue(123);
        assertDoesNotThrow(() -> testQueue.checkQueueElems());
    }

    @Test
    void testFIFOOrder() {
        intQueue.enqueue(1);
        intQueue.enqueue(2);
        intQueue.enqueue(3);

        assertEquals(1, intQueue.dequeue());
        assertEquals(2, intQueue.dequeue());
        assertEquals(3, intQueue.dequeue());
    }

    @Test
    void testClearQueueByDequeue() {
        intQueue.enqueue(1);
        intQueue.enqueue(2);

        intQueue.dequeue();
        intQueue.dequeue();

        assertTrue(intQueue.isEmpty());
        assertEquals(0, intQueue.size());
    }

    @Nested
    class BoundaryTests {
        @Test
        void testLargeNumberOfElements() {
            for (int i = 0; i < 10000; i++) {
                intQueue.enqueue(i);
            }
            assertEquals(10000, intQueue.size());
        }

        @Test
        void testMixedTypes() {
            Queue<Object> mixedQueue = new Queue<>();
            mixedQueue.enqueue("string");
            mixedQueue.enqueue(123);
            mixedQueue.enqueue(45.67);

            assertEquals("string", mixedQueue.dequeue());
            assertEquals(123, mixedQueue.dequeue());
            assertEquals(45.67, mixedQueue.dequeue());
        }
    }
}
