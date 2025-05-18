package models;

import interfaces.ElevatorState;

public class DoorsClosedState implements ElevatorState {
    @Override
    public void callElevator(Elevator elevator, int floor) {
        System.out.println("Установлен новый целевой этаж: " + floor);
        elevator.setTargetFloor(floor);
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
        if (elevator.hasTarget()) {
            if (elevator.getTargetFloor() > elevator.getCurrentFloor()) {
                elevator.setState(new MovingUpState());
                elevator.move();
            } else if (elevator.getTargetFloor() < elevator.getCurrentFloor()) {
                elevator.setState(new MovingDownState());
                elevator.move();
            } else {
                elevator.setState(new DoorOpenState());
            }
        } else {
            System.out.println("Не указан целевой этаж. Используйте callElevator()");
        }
    }

    @Override
    public void stop(Elevator elevator) {
        System.out.println("Отмена целевого этажа");
        elevator.clearTarget();
        elevator.setState(new IdleState());
    }

    @Override
    public void printStatus() {
        System.out.println("Двери лифта закрыты");
    }
}