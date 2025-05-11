import models.ComplexityStrategy;
import models.DeadlineStrategy;
import models.PriorityStrategy;
import models.TaskManager;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TaskManager manager = new TaskManager(new PriorityStrategy());

        System.out.println("Система управления задачами. Доступные команды:");
        System.out.println("1 - Установить стратегию планирования по приоритету");
        System.out.println("2 - Установить стратегию планирования по дедлайну");
        System.out.println("3 - Установить стратегию планирования по сложности");
        System.out.println("plan [задача] - Запланировать задачу");
        System.out.println("status - Текущая стратегия планирования");
        System.out.println("exit - Выход");

        while (true) {
            System.out.print("\nВведите команду: ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();

            switch (command) {
                case "1":
                    manager.setStrategy(new PriorityStrategy());
                    System.out.println("Установлена стратегия планирования по приоритету");
                    break;
                case "2":
                    manager.setStrategy(new DeadlineStrategy());
                    System.out.println("Установлена стратегия планирования по дедлайну");
                    break;
                case "3":
                    manager.setStrategy(new ComplexityStrategy());
                    System.out.println("Установлена стратегия планирования по сложности");
                    break;
                case "plan":
                    if (parts.length > 1) {
                        manager.executePlanning(parts[1]);
                    } else {
                        System.out.println("Укажите задачу для планирования");
                    }
                    break;
                case "status":
                    System.out.println("Текущая стратегия: " + manager.getCurrentStrategyName());
                    break;
                case "exit":
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неизвестная команда. Попробуйте снова.");
            }
        }

    }
}