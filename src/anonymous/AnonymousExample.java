package anonymous;

public class AnonymousExample {

    public static class Vehicle {
        public void move() {
            System.out.println("Base vehicle is moving");
        }
    }

    public void demonstrateAnonymousClass(int speed) {

        Vehicle anonymousVehicle = new Vehicle() {
            @Override
            public void move() {
                System.out.println("Anonymous vehicle is moving");
                transportSpeed();
            }
            public void transportSpeed() {
                System.out.println("Speed:" + speed);
            }
            public void additionalMethod() {
                System.out.println("This is additional method in anonymous class");
            }
        };

        anonymousVehicle.move();



    }


}