package models;


import interfaces.ElevatorState;

public class MovingUpState implements ElevatorState {
    @Override
    public void callElevator(Elevator elevator, int floor) {
        System.out.println("Лифт уже движется вверх. Текущий этаж: " + elevator.getCurrentFloor());
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
        elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
        System.out.println("Лифт поднимается на этаж " + elevator.getCurrentFloor());

        if (elevator.getCurrentFloor() == elevator.getTargetFloor()) {
            elevator.setState(new DoorOpenState());
        }
    }

    @Override
    public void stop(Elevator elevator) {
        System.out.println("Аварийная остановка лифта");
        elevator.setState(new IdleState());
    }

    @Override
    public void printStatus() {
        System.out.println("Лифт движется вверх");
    }
}