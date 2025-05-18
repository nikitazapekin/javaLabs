//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import payment.PaymentMethod;
import payment.PayPal;
public class Main {
    public static void main(String[] args) {
        PaymentMethod creditCard = new PaymentMethod() {
            @Override
            public void pay(double amount) {
                System.out.println("Paying " + amount + " by Credit Card");
            }
        };

        // Вторая версия анонимного класса на основе интерфейса
        PaymentMethod bankTransfer = new PaymentMethod() {
            private String bankName = "MyBank";

            @Override
            public void pay(double amount) {
                System.out.println("Paying " + amount + " by (" + bankName + ")");
            }

            public void displayBankInfo() {
                System.out.println("Bank: " + bankName);
            }
        };

        // Первая версия анонимного класса на основе класса PayPal
        PayPal paypal1 = new PayPal() {
            @Override
            public void validateAccount() {
                System.out.println(" PayPal validation");
                super.validateAccount();
            }
        };

        // Вторая версия анонимного класса на основе класса PayPal
        PayPal paypal2 = new PayPal() {
            private String email = "user@example.com";

            @Override
            public void validateAccount() {
                System.out.println("Validating PayPal account for: " + email);
                super.validateAccount();
            }

            public void displayEmail() {
                System.out.println("Registered email: " + email);
            }
        };


        System.out.println("=== Payment Methods ===");
        creditCard.pay(100.0);
        bankTransfer.pay(200.0);


        System.out.println("\n=== PayPal Implementations ===");
        paypal1.validateAccount();
        paypal2.validateAccount();

    }
}