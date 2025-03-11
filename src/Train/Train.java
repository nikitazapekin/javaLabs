package Train;

import RailTransport.RailTransport;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import PassangerCarriage.PassangerCarriage;

public class Train extends RailTransport {
    private List<PassangerCarriage> carriages;

    public Train(String model, int weight, int maxSpeed) {
        super(model, weight, maxSpeed);
        this.carriages = new ArrayList<>();
    }

    public void addCarriage(PassangerCarriage carriage) {
        carriages.add(carriage);
    }

    public int getTotalPassengers() {
        return carriages.stream().mapToInt(PassangerCarriage::getPassengerCount).sum();
    }

    public int getTotalLuggage() {
        return carriages.stream().mapToInt(PassangerCarriage::getLuggageCount).sum();
    }

    public List<PassangerCarriage> getSortedCarriagesByComfort() {
        List<PassangerCarriage> sortedCarriages = new ArrayList<>(carriages);
        sortedCarriages.sort(Comparator.comparingInt(PassangerCarriage::getComfortLevel).reversed());
        return sortedCarriages;
    }

    public List<PassangerCarriage> findCarriagesByPassengerRange(int min, int max) {
        List<PassangerCarriage> result = new ArrayList<>();
        for (PassangerCarriage carriage : carriages) {
            if (carriage.getPassengerCount() >= min && carriage.getPassengerCount() <= max) {
                result.add(carriage);
            }
        }
        return result;
    }

    public void printCarriages() {
        for (PassangerCarriage carriage : carriages) {
            System.out.println(carriage);
        }
    }
}
