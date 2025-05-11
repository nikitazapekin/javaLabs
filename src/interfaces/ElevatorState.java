package interfaces;

import models.Elevator;

public interface ElevatorState {
    void callElevator(Elevator elevator, int floor);
    void openDoors(Elevator elevator);
    void closeDoors(Elevator elevator);
    void move(Elevator elevator);
    void stop(Elevator elevator);
    void printStatus();
}