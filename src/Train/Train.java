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
        int total = 0;
        for (PassangerCarriage carriage : carriages) {
            total += carriage.getPassengerCount();
        }
        return total;
    }

    public int getTotalLuggage() {
        int total = 0;
        for (PassangerCarriage carriage : carriages) {
            total += carriage.getLuggageCount();
        }
        return total;
    }

    public List<PassangerCarriage> getSortedCarriagesByComfort() {
        List<PassangerCarriage> sortedCarriages = new ArrayList<>(carriages);
        for (int i = 0; i < sortedCarriages.size() - 1; i++) {
            for (int j = 0; j < sortedCarriages.size() - i - 1; j++) {
                if (sortedCarriages.get(j).getComfortLevel() < sortedCarriages.get(j + 1).getComfortLevel()) {
                    PassangerCarriage temp = sortedCarriages.get(j);
                    sortedCarriages.set(j, sortedCarriages.get(j + 1));
                    sortedCarriages.set(j + 1, temp);
                }
            }
        }
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