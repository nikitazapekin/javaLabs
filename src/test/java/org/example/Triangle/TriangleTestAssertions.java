package org.example.Triangle;


import org.example.Point.Point;
import org.example.Triangle.Triangle;
import org.junit.Test;
import static org.junit.Assert.*;

public class TriangleTestAssertions {

    @Test
    public void testAssertNotNull() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(1, 1), new Point(2, 0));
        assertNotNull(triangle);
    }

    @Test
    public void testAssertSame() {
        Point a = new Point(0, 0);
        Point b = new Point(3, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);

        assertSame(a, triangle.a);
        assertSame(b, triangle.b);
        assertSame(c, triangle.c);
    }

    @Test
    public void testAssertNotSame() {
        Point a = new Point(1, 1);
        Point b = new Point(4, 1);
        Point c = new Point(1, 5);
        Triangle triangle1 = new Triangle(a, b, c);
        Triangle triangle2 = new Triangle(a, b, new Point(1, 5));

        assertNotSame(triangle1, triangle2);
    }

    @Test
    public void testAssertTrue() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4));
        assertTrue(triangle.getArea() > 0);
    }

    @Test
    public void testAssertFalse() {
        Triangle degenerate = new Triangle(new Point(0, 0), new Point(1, 1), new Point(2, 2));
        assertFalse(degenerate.getArea() > 0);
    }
}


/*
public class TriangleTestAssertions {
}

 */
