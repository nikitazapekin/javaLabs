import abstractClasses.CarAssembly;
import models.GeelyCar;
import models.SedanCar;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Сборка седана:");
        CarAssembly sedan = new SedanCar();
        sedan.assembleCar();

        System.out.println("Сборка внедорожника:");
        CarAssembly geely = new GeelyCar();
        geely.assembleCar();


    }
}