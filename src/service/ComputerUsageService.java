package service;

import model.ComputerUsage;
import util.FileUtil;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

public class ComputerUsageService {
    private List<ComputerUsage> usages;
    private final String csvFile;
    private final Scanner scanner;

    public ComputerUsageService(String csvFile, Scanner scanner) {
        this.csvFile = csvFile;
        this.scanner = scanner;
        this.usages = FileUtil.loadDataFromFile(csvFile);
    }

    public void viewAllData() {
        if (usages.isEmpty()) {
            System.out.println("Нет данных для отображения.");
            return;
        }

        System.out.println("\nВсе записи:");
        System.out.println("№ комп.| Клиент       | Дата      | Начало | Конец ");
        System.out.println("-------+--------------+-----------+--------+-------");
        for (ComputerUsage usage : usages) {
            System.out.printf("%-6d | %-12s | %-9s | %-6s | %-6s%n",
                    usage.getComputerNumber(),
                    usage.getClientName(),
                    usage.getDate(),
                    usage.getStartTime(),
                    usage.getEndTime());
        }
    }

    public void addNewRecord() {
        try {
            System.out.println("\nДобавление новой записи:");

            System.out.print("Номер компьютера: ");
            int computerNumber = Integer.parseInt(scanner.nextLine());

            System.out.print("Фамилия и инициалы клиента: ");
            String clientName = scanner.nextLine();

            System.out.print("Дата (дд.мм.гггг): ");
            String date = scanner.nextLine();

            System.out.print("Время начала (чч:мм): ");
            String startTime = scanner.nextLine();

            System.out.print("Время окончания (чч:мм): ");
            String endTime = scanner.nextLine();

            usages.add(new ComputerUsage(computerNumber, clientName, date, startTime, endTime));
            FileUtil.saveDataToFile(csvFile, usages);
            System.out.println("Запись успешно добавлена.");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода числа: " + e.getMessage());
        }
    }

    public void generateComputerUsageReportByDate() {
        System.out.print("\nВведите дату для отчета (дд.мм.гггг): ");
        String date = scanner.nextLine();

        Map<Integer, Long> computerUsage = usages.stream()
                .filter(u -> u.getDate().equals(date))
                .collect(Collectors.groupingBy(
                        ComputerUsage::getComputerNumber,
                        Collectors.summingLong(u -> {
                            try {
                                return u.getUsageDuration();
                            } catch (ParseException e) {
                                return 0;
                            }
                        })
                ));

        if (computerUsage.isEmpty()) {
            System.out.println("Нет данных за указанную дату.");
            return;
        }

        System.out.println("\nОтчет по времени использования компьютеров на " + date + ":");
        System.out.println("№ комп.| Время использования (мин)");
        System.out.println("-------+--------------------------");
        computerUsage.forEach((computer, duration) ->
                System.out.printf("%-6d | %-24d%n", computer, duration));
    }

    public void generateComputerUsageDetails() {
        System.out.print("\nВведите номер компьютера: ");
        int computerNumber;
        try {
            computerNumber = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Некорректный номер компьютера.");
            return;
        }

        System.out.print("Введите дату (дд.мм.гггг): ");
        String date = scanner.nextLine();

        List<ComputerUsage> filteredUsages = usages.stream()
                .filter(u -> u.getComputerNumber() == computerNumber && u.getDate().equals(date))
                .sorted(Comparator.comparing(ComputerUsage::getStartTime))
                .collect(Collectors.toList());

        if (filteredUsages.isEmpty()) {
            System.out.println("Нет данных для указанного компьютера и даты.");
            return;
        }

        System.out.printf("\nДетали использования компьютера %d на %s:%n", computerNumber, date);
        System.out.println("Клиент       | Начало | Конец  | Длительность (мин)");
        System.out.println("-------------+--------+--------+-------------------");

        for (ComputerUsage usage : filteredUsages) {
            try {
                System.out.printf("%-12s | %-6s | %-6s | %-17d%n",
                        usage.getClientName(),
                        usage.getStartTime(),
                        usage.getEndTime(),
                        usage.getUsageDuration());
            } catch (ParseException e) {
                System.out.printf("%-12s | %-6s | %-6s | ошибка данных%n",
                        usage.getClientName(),
                        usage.getStartTime(),
                        usage.getEndTime());
            }
        }
    }
}