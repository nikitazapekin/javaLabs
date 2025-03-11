package RailTransport;

import Transport.Transport;

public abstract class RailTransport extends Transport {
    protected int maxSpeed;

    public RailTransport(String model, int weight, int maxSpeed) {
        super(model, weight);
        this.maxSpeed = maxSpeed;
    }
}
