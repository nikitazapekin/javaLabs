//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import Triangle.TriangleUtils;
import Triangle.Triangle;
import Point.Point;
public class Main {
    public static void main(String[] args) {



        Triangle[] triangles = {
                new Triangle(new Point(0, 0), new Point(1, 0), new Point(0, 1)),
                new Triangle(new Point(0, 0), new Point(2, 0), new Point(1, Math.sqrt(3))),
                new Triangle(new Point(0, 0), new Point(3, 0), new Point(3, 4))
        };

        for (Triangle t : triangles) {
            System.out.println("Треугольник:");
            System.out.println("Периметр: " + t.getPerimeter());
            System.out.println("Площадь: " + t.getArea());
            System.out.println("Равносторонний: " + TriangleUtils.isEquilateral(t));
            System.out.println("Равнобедренный: " + TriangleUtils.isIsosceles(t));
            System.out.println("Прямоугольный: " + TriangleUtils.isRight(t));
            System.out.println();
        }


    }
}