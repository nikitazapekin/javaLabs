package Transport;

public abstract class Transport {
    protected String model;
    protected int weight;

    public Transport(String model, int weight) {
        this.model = model;
        this.weight = weight;
    }
}
