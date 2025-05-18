package enums;

public enum VehicleType {
    CAR(200, "Gasoline") {
        @Override
        public String getFuelType() {
            return fuelType;
        }
    },
    BIKE(120, "Petrol") {
        @Override
        public String getFuelType() {
            return fuelType;
        }
    },
    BUS(100, "Diesel") {
        @Override
        public String getFuelType() {
            return fuelType;
        }
    },
    TRAIN(300, "Electricity") {
        @Override
        public String getFuelType() {
            return fuelType;
        }
    };

    private final int maxSpeed;
    protected final String fuelType;

    VehicleType(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public abstract String getFuelType();
}