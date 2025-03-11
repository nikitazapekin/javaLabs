package Transport;

public abstract class Transport {
    public  String model;
    public int weight;

    public Transport(String model, int weight) {
        this.model = model;
        this.weight = weight;
    }
}
