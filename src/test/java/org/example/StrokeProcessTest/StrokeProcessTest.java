package org.example.StrokeProcessTest;



import org.example.helpers.processString;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StrokeProcessTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Начало тестирования processString");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Завершение тестирования processString");
    }




    @Test
    void testCount() {
        String input = "hello world!";
        String result = processString.appendVowelsCount(input);
      System.out.println(result);
        assertEquals("hello world! (e:1, o:2, e:1, o:2)", result);
    }


}

