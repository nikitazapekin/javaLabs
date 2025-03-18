package org.example.TriangleUtils;



import org.example.Point.Point;
import org.example.Triangle.Triangle;
import org.example.Triangle.TriangleUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class TriangleUtilsTest {

  /*  @Test
    public void testIsEquilateral_True() {
        Triangle equilateral = new Triangle(new Point(0, 0), new Point(2, Math.sqrt(3)), new Point(4, 0));
        assertTrue(TriangleUtils.isEquilateral(equilateral));
    }
*/
    @Test
    public void testIsEquilateral_False() {
        Triangle notEquilateral = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4));
        assertFalse(TriangleUtils.isEquilateral(notEquilateral));
    }

    @Test
    public void testIsIsosceles_True() {
        Triangle isosceles = new Triangle(new Point(0, 0), new Point(2, 3), new Point(4, 0));
        assertTrue(TriangleUtils.isIsosceles(isosceles));
    }

    @Test
    public void testIsIsosceles_False() {
        Triangle notIsosceles = new Triangle(new Point(0, 0), new Point(3, 0), new Point(2, 4));
        assertFalse(TriangleUtils.isIsosceles(notIsosceles));
    }

    @Test
    public void testIsRight_True() {
        Triangle rightTriangle = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4));
        assertTrue(TriangleUtils.isRight(rightTriangle));
    }

    @Test
    public void testIsRight_False() {
        Triangle notRightTriangle = new Triangle(new Point(0, 0), new Point(2, 3), new Point(4, 0));
        assertFalse(TriangleUtils.isRight(notRightTriangle));
    }
}
