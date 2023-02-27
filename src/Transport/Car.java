package Transport;
import java.util.List;


public class Car extends Transport<DriverB> {

    private final BodyType bodyType;

    enum BodyType{
        SEDAN("Sedan"),
        HATCHBACK("Hatchback"),
        COUPE("Coupe"),
        UNIVERSAL("Universal"),
        SUV("SUV"),
        CROSSOVER("Crossover"),
        PICKUP("Pickup"),
        VAN("Van"),
        MINIVAN("Minivan");

        private final String bodyType;

        BodyType(String bodyType) {
            this.bodyType = bodyType;
        }

        public String getBodyType(){
            return bodyType;
        }

    }

    public Car(String brand, String model,  double engineVolume, DriverB driver, BodyType bodyType, Type type, List<Mechanic> mechanics) {
        super(brand, model, engineVolume, driver, type, mechanics);
        this.bodyType = bodyType;
    }


    @Override
    public String toString() {
        return "Тип кузова " + bodyType + " " + super.toString();
    }

    @Override
    public void startMove() {
        System.out.println("Автомобиль марки " + getBrand() + " начал движение ");
    }

    @Override
    public void finishMove() {
        System.out.println("Автомобиль марки " + getBrand() + " закончил движение ");
    }

    @Override
    public Type getType() {
        return Type.CAR;
    }
    @Override
    public boolean diagnostic() throws TransportTypeException {
        System.out.println("Пройти диагностику легкового автомобиля");
        return true;
    }

    @Override
    public void printType() {
        System.out.println("Тип автомобиля " + (this.bodyType != null ? this.bodyType.toString() : " Данных по транспортному средству недостаточно"));
    }

    @Override
    public void pitStop() {
        System.out.println("Пит стоп у автомобиля");
    }

    @Override
    public void theBestCircleTime() {
        int minBound = 70;
        int maxBound = 120;
        int theBestTimeInMins = (int) (minBound + (maxBound - minBound) + Math.random());

        System.out.println("Лучшее время круга для автомобиля " + theBestTimeInMins);
    }

    @Override
    public void maxSpeed() {
        int minBound = 100;
        int maxBound = 160;
        int maxSpeed = (int) (minBound + (maxBound - minBound) + Math.random());
        System.out.println("Максимальная скорость для автомобиля " + maxSpeed);
    }
}
