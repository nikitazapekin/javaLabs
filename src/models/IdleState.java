package models;

import interfaces.ElevatorState;

public class IdleState implements ElevatorState {
    @Override
    public void callElevator(Elevator elevator, int floor) {
        System.out.println("Установлен целевой этаж: " + floor);
        elevator.setTargetFloor(floor);
    }

    @Override
    public void openDoors(Elevator elevator) {
        System.out.println("Открытие дверей");
        elevator.setState(new DoorOpenState());
    }

    @Override
    public void closeDoors(Elevator elevator) {
        System.out.println("Двери уже закрыты в состоянии ожидания");
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
    }

    @Override
    public void printStatus() {
        System.out.println("Лифт в режиме ожидания");
    }
}