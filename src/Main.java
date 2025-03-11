import java.util.*;
import Transport.Transport;
import RailTransport.RailTransport;
import Train.Train;
 import PassangerCarriage.PassangerCarriage;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Train train = new Train("Express", 5000, 120);
        train.addCarriage(new PassangerCarriage(50, 100, 3));
        train.addCarriage(new PassangerCarriage(40, 80, 2));
        train.addCarriage(new PassangerCarriage(60, 120, 4));

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1 - Показать список вагонов");
            System.out.println("2 - Сортировать вагоны по уровню комфорта");
            System.out.println("3 - Найти вагоны по количеству пассажиров");
            System.out.println("4 - Показать общее число пассажиров и багажа");
            System.out.println("5 - Добавить новый вагон");
            System.out.println("6 - Выйти из программы");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    train.printCarriages();
                    break;
                case 2:
                    List<PassangerCarriage> sortedCarriages = train.getSortedCarriagesByComfort();
                    sortedCarriages.forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Введите минимальное число пассажиров: ");
                    int min = scanner.nextInt();
                    System.out.print("Введите максимальное число пассажиров: ");
                    int max = scanner.nextInt();
                    List<PassangerCarriage> found = train.findCarriagesByPassengerRange(min, max);
                    if (found.isEmpty()) {
                        System.out.println("Нет вагонов с таким числом пассажиров.");
                    } else {
                        found.forEach(System.out::println);
                    }
                    break;
                case 4:
                    System.out.println("Общее количество пассажиров: " + train.getTotalPassengers());
                    System.out.println("Общее количество багажа: " + train.getTotalLuggage());
                    break;
                case 5:
                    System.out.print("Введите количество пассажиров: ");
                    int passengers = scanner.nextInt();
                    System.out.print("Введите количество багажа: ");
                    int luggage = scanner.nextInt();
                    System.out.print("Введите уровень комфорта: ");
                    int comfort = scanner.nextInt();
                    train.addCarriage(new PassangerCarriage(passengers, luggage, comfort));
                    System.out.println("Вагон добавлен.");
                    break;
                case 6:
                    System.out.println("Выход из программы...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Некорректный ввод, попробуйте снова.");
            }
        }
    }
}
