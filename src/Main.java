import java.util.*;

// Абстрактный класс Транспорт
abstract class Transport {
    protected String model;
    protected int weight;

    public Transport(String model, int weight) {
        this.model = model;
        this.weight = weight;
    }
}

// Абстрактный класс Железнодорожный транспорт
abstract class RailTransport extends Transport {
    protected int maxSpeed;

    public RailTransport(String model, int weight, int maxSpeed) {
        super(model, weight);
        this.maxSpeed = maxSpeed;
    }
}

// Класс Поезд
class Train extends RailTransport {
    private List<PassengerCarriage> carriages;

    public Train(String model, int weight, int maxSpeed) {
        super(model, weight, maxSpeed);
        this.carriages = new ArrayList<>();
    }

    public void addCarriage(PassengerCarriage carriage) {
        carriages.add(carriage);
    }

    public int getTotalPassengers() {
        return carriages.stream().mapToInt(PassengerCarriage::getPassengerCount).sum();
    }

    public int getTotalLuggage() {
        return carriages.stream().mapToInt(PassengerCarriage::getLuggageCount).sum();
    }

    public List<PassengerCarriage> getSortedCarriagesByComfort() {
        List<PassengerCarriage> sortedCarriages = new ArrayList<>(carriages);
        sortedCarriages.sort(Comparator.comparingInt(PassengerCarriage::getComfortLevel).reversed());
        return sortedCarriages;
    }

    public List<PassengerCarriage> findCarriagesByPassengerRange(int min, int max) {
        List<PassengerCarriage> result = new ArrayList<>();
        for (PassengerCarriage carriage : carriages) {
            if (carriage.getPassengerCount() >= min && carriage.getPassengerCount() <= max) {
                result.add(carriage);
            }
        }
        return result;
    }

    public void printCarriages() {
        for (PassengerCarriage carriage : carriages) {
            System.out.println(carriage);
        }
    }
}

// Абстрактный класс Вагона
abstract class Carriage {
    protected int passengerCount;
    protected int luggageCount;
    protected int comfortLevel;

    public Carriage(int passengerCount, int luggageCount, int comfortLevel) {
        this.passengerCount = passengerCount;
        this.luggageCount = luggageCount;
        this.comfortLevel = comfortLevel;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public int getLuggageCount() {
        return luggageCount;
    }

    public int getComfortLevel() {
        return comfortLevel;
    }
}

// Класс Пассажирский вагон
class PassengerCarriage extends Carriage {
    public PassengerCarriage(int passengerCount, int luggageCount, int comfortLevel) {
        super(passengerCount, luggageCount, comfortLevel);
    }

    @Override
    public String toString() {
        return "Пассажирский вагон: " +
                "Пассажиры = " + passengerCount +
                ", Багаж = " + luggageCount +
                ", Комфорт = " + comfortLevel;
    }
}

// Главный класс
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Train train = new Train("Express", 5000, 120);
        train.addCarriage(new PassengerCarriage(50, 100, 3));
        train.addCarriage(new PassengerCarriage(40, 80, 2));
        train.addCarriage(new PassengerCarriage(60, 120, 4));

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
                    List<PassengerCarriage> sortedCarriages = train.getSortedCarriagesByComfort();
                    sortedCarriages.forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Введите минимальное число пассажиров: ");
                    int min = scanner.nextInt();
                    System.out.print("Введите максимальное число пассажиров: ");
                    int max = scanner.nextInt();
                    List<PassengerCarriage> found = train.findCarriagesByPassengerRange(min, max);
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
                    train.addCarriage(new PassengerCarriage(passengers, luggage, comfort));
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


/*
import java.util.*;

// Абстрактный класс Транспорт
abstract class Transport {
    protected String model;
    protected int weight;

    public Transport(String model, int weight) {
        this.model = model;
        this.weight = weight;
    }
}

// Абстрактный класс Железнодорожный транспорт
abstract class RailTransport extends Transport {
    protected int maxSpeed;

    public RailTransport(String model, int weight, int maxSpeed) {
        super(model, weight);
        this.maxSpeed = maxSpeed;
    }
}

// Класс Поезд
class Train extends RailTransport {
    private List<PassengerCarriage> carriages;

    public Train(String model, int weight, int maxSpeed) {
        super(model, weight, maxSpeed);
        this.carriages = new ArrayList<>();
    }

    public void addCarriage(PassengerCarriage carriage) {
        carriages.add(carriage);
    }

    public int getTotalPassengers() {
        return carriages.stream().mapToInt(PassengerCarriage::getPassengerCount).sum();
    }

    public int getTotalLuggage() {
        return carriages.stream().mapToInt(PassengerCarriage::getLuggageCount).sum();
    }

    public void sortCarriagesByComfort() {
        carriages.sort(Comparator.comparingInt(PassengerCarriage::getComfortLevel).reversed());
    }

    public List<PassengerCarriage> findCarriagesByPassengerRange(int min, int max) {
        List<PassengerCarriage> result = new ArrayList<>();
        for (PassengerCarriage carriage : carriages) {
            if (carriage.getPassengerCount() >= min && carriage.getPassengerCount() <= max) {
                result.add(carriage);
            }
        }
        return result;
    }

    public void printCarriages() {
        for (PassengerCarriage carriage : carriages) {
            System.out.println(carriage);
        }
    }
}

// Абстрактный класс Вагона
abstract class Carriage {
    protected int passengerCount;
    protected int luggageCount;
    protected int comfortLevel;

    public Carriage(int passengerCount, int luggageCount, int comfortLevel) {
        this.passengerCount = passengerCount;
        this.luggageCount = luggageCount;
        this.comfortLevel = comfortLevel;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public int getLuggageCount() {
        return luggageCount;
    }

    public int getComfortLevel() {
        return comfortLevel;
    }
}

// Класс Пассажирский вагон
class PassengerCarriage extends Carriage {
    public PassengerCarriage(int passengerCount, int luggageCount, int comfortLevel) {
        super(passengerCount, luggageCount, comfortLevel);
    }

    @Override
    public String toString() {
        return "Пассажирский вагон: " +
                "Пассажиры = " + passengerCount +
                ", Багаж = " + luggageCount +
                ", Комфорт = " + comfortLevel;
    }
}

// Главный класс
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Train train = new Train("Express", 5000, 120);
        train.addCarriage(new PassengerCarriage(50, 100, 3));
        train.addCarriage(new PassengerCarriage(40, 80, 2));
        train.addCarriage(new PassengerCarriage(60, 120, 4));

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1 - Показать список вагонов");
            System.out.println("2 - Сортировать вагоны по уровню комфорта");
            System.out.println("3 - Найти вагоны по количеству пассажиров");
            System.out.println("4 - Показать общее число пассажиров и багажа");
            System.out.println("5 - Выйти из программы");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    train.printCarriages();
                    break;
                case 2:
                    train.sortCarriagesByComfort();
                    System.out.println("Вагоны отсортированы по уровню комфорта.");
                    break;
                case 3:
                    System.out.print("Введите минимальное число пассажиров: ");
                    int min = scanner.nextInt();
                    System.out.print("Введите максимальное число пассажиров: ");
                    int max = scanner.nextInt();
                    List<PassengerCarriage> found = train.findCarriagesByPassengerRange(min, max);
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
                    System.out.println("Выход из программы...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Некорректный ввод, попробуйте снова.");
            }
        }
    }
}
*/
/*


import java.util.*;

// Абстрактный класс Транспорт
abstract class Transport {
    protected String model;
    protected int weight;

    public Transport(String model, int weight) {
        this.model = model;
        this.weight = weight;
    }
}

// Абстрактный класс Железнодорожный транспорт
abstract class RailTransport extends Transport {
    protected int maxSpeed;

    public RailTransport(String model, int weight, int maxSpeed) {
        super(model, weight);
        this.maxSpeed = maxSpeed;
    }
}

// Класс Поезд
class Train extends RailTransport {
    private List<PassengerCarriage> carriages;

    public Train(String model, int weight, int maxSpeed) {
        super(model, weight, maxSpeed);
        this.carriages = new ArrayList<>();
    }

    public void addCarriage(PassengerCarriage carriage) {
        carriages.add(carriage);
    }

    public int getTotalPassengers() {
        return carriages.stream().mapToInt(PassengerCarriage::getPassengerCount).sum();
    }

    public int getTotalLuggage() {
        return carriages.stream().mapToInt(PassengerCarriage::getLuggageCount).sum();
    }

    public void sortCarriagesByComfort() {
        carriages.sort(Comparator.comparingInt(PassengerCarriage::getComfortLevel).reversed());
    }

    public List<PassengerCarriage> findCarriagesByPassengerRange(int min, int max) {
        List<PassengerCarriage> result = new ArrayList<>();
        for (PassengerCarriage carriage : carriages) {
            if (carriage.getPassengerCount() >= min && carriage.getPassengerCount() <= max) {
                result.add(carriage);
            }
        }
        return result;
    }

    public void printCarriages() {
        for (PassengerCarriage carriage : carriages) {
            System.out.println(carriage);
        }
    }
}

// Абстрактный класс Вагона
abstract class Carriage {
    protected int passengerCount;
    protected int luggageCount;
    protected int comfortLevel;

    public Carriage(int passengerCount, int luggageCount, int comfortLevel) {
        this.passengerCount = passengerCount;
        this.luggageCount = luggageCount;
        this.comfortLevel = comfortLevel;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public int getLuggageCount() {
        return luggageCount;
    }

    public int getComfortLevel() {
        return comfortLevel;
    }
}

// Класс Пассажирский вагон
class PassengerCarriage extends Carriage {
    public PassengerCarriage(int passengerCount, int luggageCount, int comfortLevel) {
        super(passengerCount, luggageCount, comfortLevel);
    }

    @Override
    public String toString() {
        return "Пассажирский вагон: " +
                "Пассажиры = " + passengerCount +
                ", Багаж = " + luggageCount +
                ", Комфорт = " + comfortLevel;
    }
}

// Главный класс
public class Main {
    public static void main(String[] args) {
        Train train = new Train("Express", 5000, 120);
        train.addCarriage(new PassengerCarriage(50, 100, 3));
        train.addCarriage(new PassengerCarriage(40, 80, 2));
        train.addCarriage(new PassengerCarriage(60, 120, 4));

        System.out.println("Общее количество пассажиров: " + train.getTotalPassengers());
        System.out.println("Общее количество багажа: " + train.getTotalLuggage());

        System.out.println("Вагоны до сортировки:");
        train.printCarriages();

        train.sortCarriagesByComfort();
        System.out.println("Вагоны после сортировки по комфорту:");
        train.printCarriages();

        System.out.println("Вагоны с пассажирами от 45 до 55:");
        for (PassengerCarriage carriage : train.findCarriagesByPassengerRange(45, 55)) {
            System.out.println(carriage);
        }
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.



 */