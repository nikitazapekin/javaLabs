package models;


import abstractClasses.CarAssembly;

public class GeelyCar extends CarAssembly {
    @Override
    protected void installInterior() {
        System.out.println("Устанавливаем практичный салон с защитой от влаги");
    }

    @Override
    protected void installEngine() {
        System.out.println("Устанавливаем мощный внедорожный двигатель");
    }
}