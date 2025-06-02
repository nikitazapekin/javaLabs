import service.ComputerUsageService;
import java.util.Scanner;

class Main {

    private static final String CSV_FILE = "computer_usage.csv";
   // private static final String CSV_FILE = "computer_usage.txt";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ComputerUsageService service = new ComputerUsageService(CSV_FILE, scanner);
        while (true) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    service.viewAllData();
                    break;
                case "2":
                    service.addNewRecord();
                    break;
                case "3":
                    service.generateComputerUsageReportByDate();
                    break;
                case "4":
                    service.generateComputerUsageDetails();
                    break;
                case "5":
                    System.out.println("Программа завершена.");
                    return;
                default:
                    System.out.println("Неверный ввод. Попробуйте снова.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Меню:");
        System.out.println("1. Просмотреть все данные");
        System.out.println("2. Добавить новую запись");
        System.out.println("3. Отчет по времени использования компьютеров на дату");
        System.out.println("4. Детали использования компьютера на дату");
        System.out.println("5. Выход");
        System.out.print("Выберите действие: ");
    }
}