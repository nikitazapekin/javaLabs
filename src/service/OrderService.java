package service;

import model.Order;
import util.SerializationUtil;

import java.util.*;
import java.util.stream.Collectors;

public class OrderService {
    private static final String DATA_FILE = "orders.dat";
    private Set<Order> orders;
    private final Scanner scanner;

    public OrderService(Scanner scanner) {
        this.scanner = scanner;
        this.orders = new HashSet<>(SerializationUtil.loadData(DATA_FILE));
    }

    public void addOrder() {
        System.out.println("\nДобавление нового заказа:");

        System.out.print("ФИО покупателя: ");
        String customer = scanner.nextLine();

        System.out.print("Название товара: ");
        String product = scanner.nextLine();

        System.out.print("Количество: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.print("Цена за единицу: ");
        double price = Double.parseDouble(scanner.nextLine());

        Order newOrder = new Order(customer, product, quantity, price);
        orders.add(newOrder);
        SerializationUtil.saveData(DATA_FILE, new ArrayList<>(orders));
        System.out.println("Заказ добавлен!");
    }

    public void removeOrder() {
        System.out.println("\nУдаление заказа:");
        listAllOrders();

        System.out.print("Введите номер заказа для удаления: ");
        int index = Integer.parseInt(scanner.nextLine());

        if (index > 0 && index <= orders.size()) {
            Order orderToRemove = new ArrayList<>(orders).get(index - 1);
            orders.remove(orderToRemove);
            SerializationUtil.saveData(DATA_FILE, new ArrayList<>(orders));
            System.out.println("Заказ удален!");
        } else {
            System.out.println("Неверный номер заказа!");
        }
    }

    public void showCustomerOrders() {
        Map<String, List<Order>> customerOrders = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomerName));

        System.out.println("\nЗаказы по покупателям:");
        customerOrders.forEach((customer, ordersList) -> {
            double total = ordersList.stream().mapToDouble(Order::getTotalPrice).sum();
            System.out.printf("\n%s (Всего: %.2f):\n", customer, total);
            ordersList.forEach(order -> System.out.println("  " + order));
        });
    }

    public void showProductOrders() {
        Map<String, List<Order>> productOrders = orders.stream()
                .collect(Collectors.groupingBy(Order::getProductName));

        System.out.println("\nЗаказы по товарам:");
        productOrders.forEach((product, ordersList) -> {
            double total = ordersList.stream().mapToDouble(Order::getTotalPrice).sum();
            System.out.printf("\n%s (Всего: %.2f):\n", product, total);
            ordersList.forEach(order -> System.out.println("  " + order));
        });
    }

    public void listAllOrders() {
        System.out.println("\nВсе заказы:");
        if (orders.isEmpty()) {
            System.out.println("Нет заказов");
            return;
        }

        int index = 1;
        for (Order order : orders) {
            System.out.printf("%d. %s\n", index++, order);
        }
    }
}