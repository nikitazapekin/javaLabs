package models;

import interfaces.ElevatorState;

public class MovingUpState implements ElevatorState {
    @Override
    public void callElevator(Elevator elevator, int floor) {
        System.out.println("Изменение целевого этажа на " + floor + " во время движения");
        elevator.setTargetFloor(floor);
    }

    @Override
    public void openDoors(Elevator elevator) {
        System.out.println("Нельзя открыть двери во время движения");
    }

    @Override
    public void closeDoors(Elevator elevator) {
        System.out.println("Двери уже закрыты во время движения");
    }

    @Override
    public void move(Elevator elevator) {
        int newFloor = elevator.getCurrentFloor() + 1;
        elevator.setCurrentFloor(newFloor);
        System.out.println("Лифт поднимается на этаж " + newFloor);

        if (newFloor == elevator.getTargetFloor()) {
            elevator.setState(new DoorOpenState());
        } else if (newFloor > elevator.getTargetFloor()) {

            elevator.setState(new MovingDownState());
        }
    }

    @Override
    public void stop(Elevator elevator) {
        System.out.println("Аварийная остановка лифта");
        elevator.clearTarget();
        elevator.setState(new IdleState());
    }

    @Override
    public void printStatus() {
        System.out.println("Лифт движется вверх");
    }
}