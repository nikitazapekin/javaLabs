package PassangerCarriage;
import Carriage.Carriage;





public class PassangerCarriage extends Carriage {
    public PassangerCarriage(int passengerCount, int luggageCount, int comfortLevel) {
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