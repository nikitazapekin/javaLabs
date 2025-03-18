package Test;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class MyFirstTest {
    @Test
    public void testMethod1() {
        assertEquals(2, 1 + 1);
    }
}