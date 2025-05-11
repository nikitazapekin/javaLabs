package abstractClasses;


public abstract class CarAssembly {

    public final void assembleCar() {
        installFrame();
        installEngine();
        if (hasSunroof()) {
            installSunroof();
        }
        installInterior();
        System.out.println("Автомобиль собран!\n");
    }


    private void installFrame() {
        System.out.println("Устанавливаем раму автомобиля");
    }

    protected void installEngine() {
        System.out.println("Устанавливаем стандартный двигатель");
    }

    protected abstract void installInterior();


    protected boolean hasSunroof() {
        return false;
    }

    protected void installSunroof() {

    }
}