package Transport;

public class DriverD extends Driver{
    public DriverD(String name,
                   boolean hasDriverLicense,
                   int experienceInYears) {
        super(name, hasDriverLicense, experienceInYears);
    }
    @Override
    public String toString() {
        return super.toString() + ", водитель категории D";
    }
    @Override
    public void startMove() {
        System.out.println(" Водитель категории D " + getName() + " начал движение");
    }

    @Override
    public void finishMove() {
        System.out.println(" Водитель категории D " + getName() + " закончил движение");
    }

    @Override
    public void refill() {
        System.out.println(" Водитель категории D " + getName() + " заправляет автомобиль");
    }
}
