public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Ошибка: укажите угол в градусах в качестве аргумента.");
            return;
        }

        double degrees = Double.parseDouble(args[0]);
        double radians = degrees * Math.PI / 180;

        System.out.printf("Угол в радианах: %.4f%n", radians);
    }
}
