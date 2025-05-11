package models;

import interfaces.ElevatorState;

public class DoorsClosedState implements ElevatorState {
    @Override
    public void callElevator(Elevator elevator, int floor) {
        System.out.println("Лифт готов к движению. Используйте move()");
    }

    @Override
    public void openDoors(Elevator elevator) {
        System.out.println("Открытие дверей");
        elevator.setState(new DoorOpenState());
    }

    @Override
    public void closeDoors(Elevator elevator) {
        System.out.println("Двери уже закрыты");
    }

    @Override
    public void move(Elevator elevator) {
        if (elevator.getTargetFloor() > elevator.getCurrentFloor()) {
            elevator.setState(new MovingUpState());
        } else if (elevator.getTargetFloor() < elevator.getCurrentFloor()) {
            elevator.setState(new MovingDownState());
        } else {
            System.out.println("Лифт уже на целевом этаже");
        }
    }

    @Override
    public void stop(Elevator elevator) {
        System.out.println("Лифт уже остановлен с закрытыми дверями");
    }

    @Override
    public void printStatus() {
        System.out.println("Двери лифта закрыты");
    }
}