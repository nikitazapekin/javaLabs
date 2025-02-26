package Point;

/**
 * Класс, представляющий точку в двумерном пространстве.
 */
public class Point {

    public double x;

    /**
     * Координата Y точки.
     */

    public double y;

    /**
     * Создает новую точку с заданными координатами.
     *
     * @param x Координата X
     * @param y Координата Y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Возвращает координату X точки.
     *
     * @return Координата X
     */
    public double getX() {
        return x;
    }

    /**
     * Возвращает координату Y точки.
     *
     * @return Координата Y
     */
    public double getY() {
        return y;
    }

    /**
     * Вычисляет расстояние между текущей точкой и другой точкой.
     *
     * @param other Другая точка, до которой вычисляется расстояние
     * @return Расстояние между двумя точками
     */
    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}
