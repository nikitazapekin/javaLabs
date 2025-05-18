package models;

import interfaces.ElevatorState;

public class Elevator {
    private ElevatorState state;
    private int currentFloor;
    private int targetFloor;
    private boolean hasTarget;

    public Elevator() {
        this.state = new IdleState();
        this.currentFloor = 1;
        this.targetFloor = 1;
        this.hasTarget = false;
    }

    public void setState(ElevatorState state) {
        this.state = state;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int floor) {
        this.currentFloor = floor;
    }

    public int getTargetFloor() {
        return targetFloor;
    }

    public void setTargetFloor(int floor) {
        this.targetFloor = floor;
        this.hasTarget = true;
    }

    public boolean hasTarget() {
        return hasTarget;
    }

    public void clearTarget() {
        this.hasTarget = false;
        this.targetFloor = currentFloor;
    }

    public void callElevator(int floor) {
        this.setTargetFloor(floor);
        state.callElevator(this, floor);
    }

    public void openDoors() {
        state.openDoors(this);
    }

    public void closeDoors() {
        state.closeDoors(this);
    }

    public void move() {
        state.move(this);
    }

    public void stop() {
        state.stop(this);
    }

    public void printStatus() {
        state.printStatus();
        System.out.println("Текущий этаж: " + currentFloor);
        if (hasTarget) {
            System.out.println("Целевой этаж: " + targetFloor);
        }
    }
}