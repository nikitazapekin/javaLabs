package models;

import interfaces.ElevatorState;

public class DoorOpenState implements ElevatorState {
    @Override
    public void callElevator(Elevator elevator, int floor) {
        System.out.println("Установлен целевой этаж: " + floor);
        elevator.setTargetFloor(floor);
    }

    @Override
    public void openDoors(Elevator elevator) {
        System.out.println("Двери уже открыты");
    }

    @Override
    public void closeDoors(Elevator elevator) {
        System.out.println("Закрытие дверей");
        elevator.setState(new DoorsClosedState());
    }

    @Override
    public void move(Elevator elevator) {
        System.out.println("Нельзя двигаться с открытыми дверями");
    }

    @Override
    public void stop(Elevator elevator) {
        System.out.println("Отмена целевого этажа");
        elevator.clearTarget();
    }

    @Override
    public void printStatus() {
        System.out.println("Двери лифта открыты");
    }
}