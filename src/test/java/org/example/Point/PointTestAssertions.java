package org.example.Point;





import org.junit.Test;
import static org.junit.Assert.*;

public class PointTestAssertions {

    @Test
    public void testAssertNotNull() {
        Point p = new Point(1, 2);
        assertNotNull(p);
    }

    @Test
    public void testAssertSame() {
        Point p1 = new Point(5, 5);
        Point p2 = p1;
        assertSame(p1, p2);
    }

    @Test
    public void testAssertNotSame() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 1);
        assertNotSame(p1, p2);
    }

    @Test
    public void testAssertTrue() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        assertTrue(p1.distanceTo(p2) == 5);
    }

    @Test
    public void testAssertFalse() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 3);
        assertFalse(p1.distanceTo(p2) == 5);
    }
}

/*
public class PointTestAssertions {
}

 */
