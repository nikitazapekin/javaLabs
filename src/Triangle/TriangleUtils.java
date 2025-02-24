package Triangle;
import Triangle.Triangle;
public  class TriangleUtils {
    public static boolean isEquilateral(Triangle t) {
        double ab = t.a.distanceTo(t.b);
        double bc = t.b.distanceTo(t.c);
        double ca = t.c.distanceTo(t.a);
        return ab == bc && bc == ca;
    }

    public static boolean isIsosceles(Triangle t) {
        double ab = t.a.distanceTo(t.b);
        double bc = t.b.distanceTo(t.c);
        double ca = t.c.distanceTo(t.a);
        return ab == bc || bc == ca || ca == ab;
    }

    public static boolean isRight(Triangle t) {
        double ab = t.a.distanceTo(t.b);
        double bc = t.b.distanceTo(t.c);
        double ca = t.c.distanceTo(t.a);
        double[] sides = {ab, bc, ca};
        java.util.Arrays.sort(sides);
        return Math.abs(sides[2] * sides[2] - (sides[0] * sides[0] + sides[1] * sides[1])) == 0;
    }
}
