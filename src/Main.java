import enums.VehicleType;
import anonymous.AnonymousExample;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Vehicle Types Information ===");
        for (VehicleType type : VehicleType.values()) {
            System.out.println("Type: " + type);
            System.out.println("Max speed: " + type.getMaxSpeed() + " km/h");
            System.out.println("Fuel type: " + type.getFuelType());
            System.out.println("---------------------");
        }


        System.out.println("\n=== Anonymous Class Demonstration ===");
        AnonymousExample example = new AnonymousExample();
        example.demonstrateAnonymousClass();
    }


}