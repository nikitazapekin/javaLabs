package models;


import interfaces.ElevatorState;

public class Elevator {
    private ElevatorState state;
    private int currentFloor;
    private int targetFloor;

    public Elevator() {
        this.state = new IdleState();
        this.currentFloor = 1;
        this.targetFloor = 1;
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
    }

    public void callElevator(int floor) {
        this.targetFloor = floor;
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
    }
}