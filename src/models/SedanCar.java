package models;


import abstractClasses.CarAssembly;

public class SedanCar extends CarAssembly {
    @Override
    protected void installInterior() {
        System.out.println("Устанавливаем кожанный салон с подогревом сидений");
    }

    @Override
    protected boolean hasSunroof() {
        return true;
    }

    @Override
    protected void installSunroof() {
        System.out.println("Устанавливаем панорамный люк");
    }
}
