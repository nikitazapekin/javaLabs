import service.OrderService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderService service = new OrderService(scanner);

        while (true) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    service.listAllOrders();
                    break;
                case "2":
                    service.addOrder();
                    break;
                case "3":
                    service.removeOrder();
                    break;
                case "4":
                    service.showCustomerOrders();
                    break;
                case "5":
                    service.showProductOrders();
                    break;
                case "6":
                    System.out.println("Выход из программы");
                    return;
                default:
                    System.out.println("Неверный ввод!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nМеню Интернет-магазина:");
        System.out.println("1. Показать все заказы");
        System.out.println("2. Добавить заказ");
        System.out.println("3. Удалить заказ");
        System.out.println("4. Отчет по покупателям");
        System.out.println("5. Отчет по товарам");
        System.out.println("6. Выход");
        System.out.print("Выберите действие: ");
    }
}