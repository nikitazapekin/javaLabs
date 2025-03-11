package Carriage;

public abstract class Carriage {
    protected int passengerCount;
    protected int luggageCount;
    protected int comfortLevel;

    public Carriage(int passengerCount, int luggageCount, int comfortLevel) {
        this.passengerCount = passengerCount;
        this.luggageCount = luggageCount;
        this.comfortLevel = comfortLevel;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public int getLuggageCount() {
        return luggageCount;
    }

    public int getComfortLevel() {
        return comfortLevel;
    }
}
