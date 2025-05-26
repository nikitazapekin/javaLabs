package model;


import java.io.Serializable;
import java.util.Objects;

public class Order implements Serializable {
    private String customerName;
    private String productName;
    private int quantity;
    private double unitPrice;

    public Order(String customerName, String productName, int quantity, double unitPrice) {
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
    public double getTotalPrice() {
        return quantity * unitPrice;
    }
    public String getCustomerName() { return customerName; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getUnitPrice() { return unitPrice; }

    @Override
    public String toString() {
        return String.format("%s: %s x%d * %.2f = %.2f",
                customerName, productName, quantity, unitPrice, getTotalPrice());
    }
    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return quantity == order.quantity &&
                Double.compare(order.unitPrice, unitPrice) == 0 &&
                Objects.equals(customerName, order.customerName) &&
                Objects.equals(productName, order.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerName, productName, quantity, unitPrice);
    }

     */
}