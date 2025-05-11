package models;


import interfaces.ElevatorState;

public class IdleState implements ElevatorState {
    @Override
    public void callElevator(Elevator elevator, int floor) {
        System.out.println("Вызов лифта на этаж " + floor);
        if (floor > elevator.getCurrentFloor()) {
            elevator.setState(new MovingUpState());
        } else if (floor < elevator.getCurrentFloor()) {
            elevator.setState(new MovingDownState());
        } else {
            elevator.setState(new DoorOpenState());
        }
    }

    @Override
    public void openDoors(Elevator elevator) {
        System.out.println("Открытие дверей из состояния ожидания");
        elevator.setState(new DoorOpenState());
    }

    @Override
    public void closeDoors(Elevator elevator) {
        System.out.println("Двери уже закрыты в состоянии ожидания");
    }

    @Override
    public void move(Elevator elevator) {
        System.out.println("Не указан этаж для движения. Используйте callElevator()");
    }

    @Override
    public void stop(Elevator elevator) {
        System.out.println("Лифт уже остановлен в состоянии ожидания");
    }

    @Override
    public void printStatus() {
        System.out.println("Лифт в режиме ожидания");
    }
}