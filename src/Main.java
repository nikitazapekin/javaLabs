import models.Elevator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Elevator elevator = new Elevator();

        System.out.println("Управление лифтом. Доступные команды:");
        System.out.println("call N - установить целевой этаж N");
        System.out.println("open - открыть двери");
        System.out.println("close - закрыть двери");
        System.out.println("move - сделать шаг движения (1 этаж)");
        System.out.println("stop - отменить целевой этаж/аварийная остановка");
        System.out.println("status - показать состояние лифта");
        System.out.println("exit - выход");

        while (true) {
            System.out.print("\nВведите команду: ");
            String input = scanner.nextLine().trim().toLowerCase();
            String[] parts = input.split(" ");

            try {
                switch (parts[0]) {
                    case "call":
                        if (parts.length < 2) {
                            System.out.println("Укажите этаж");
                            break;
                        }
                        int floor = Integer.parseInt(parts[1]);
                        elevator.callElevator(floor);
                        break;
                    case "open":
                        elevator.openDoors();
                        break;
                    case "close":
                        elevator.closeDoors();
                        break;
                    case "move":
                        elevator.move();
                        break;
                    case "stop":
                        elevator.stop();
                        break;
                    case "status":
                        elevator.printStatus();
                        break;
                    case "exit":
                        System.out.println("Выход из программы.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Неизвестная команда. Попробуйте снова.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректный номер этажа");
            }
        }
    }
}