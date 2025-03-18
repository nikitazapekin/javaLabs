package org.example.TriangleUtils;


import org.example.Point.Point;
import org.example.Triangle.Triangle;
import org.example.Triangle.TriangleUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class TriangleUtilsAssertionsTest {

    @Test
    public void testAssertNotNull() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4));
        assertNotNull(triangle);
    }

    @Test
    public void testAssertSame() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4));
        assertSame(triangle.a, triangle.a);
        assertSame(triangle.b, triangle.b);
        assertSame(triangle.c, triangle.c);
    }

    @Test
    public void testAssertNotSame() {
        Triangle triangle1 = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4));
        Triangle triangle2 = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4));
        assertNotSame(triangle1, triangle2);
    }

    @Test
    public void testAssertTrue() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4));
        assertTrue(TriangleUtils.isRight(triangle));
    }

    @Test
    public void testAssertFalse() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(2, 3), new Point(4, 0));
        assertFalse(TriangleUtils.isRight(triangle));
    }
}
