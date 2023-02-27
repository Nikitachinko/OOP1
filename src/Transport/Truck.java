package Transport;
import java.util.List;


public class Truck extends Transport<DriverC>{

    private final LoadCapacity loadCapacity;

    enum LoadCapacity {
        N1(null,3.5F),
        N2(3.5F,12F),
        N3(12F,null);

        private final Float upperLoadLimits;
        private final Float lowerLoadLimits;

        LoadCapacity(Float lowerLoadLimits, Float upperLoadLimits) {
            this.lowerLoadLimits = lowerLoadLimits;
            this.upperLoadLimits = upperLoadLimits;
        }

        public Float getUpperLoadLimits() {
            return upperLoadLimits;
        }

        public Float getLowerLoadLimits() {
            return lowerLoadLimits;
        }

        @Override
        public String toString() {
            return "Грузоподъемность: " +
                    (getLowerLoadLimits() == null ? "" : "от " + getLowerLoadLimits() + " тонн ") +
                    (getUpperLoadLimits() == null ? "" : "до " + getUpperLoadLimits() + " тонн.");
        }
    }


    public Truck(String brand, String model,  double engineVolume, DriverC driver,  LoadCapacity loadCapacity,Type type,List<Mechanic> mechanics) {
        super(brand, model,  engineVolume, driver, type,mechanics);
        this.loadCapacity = loadCapacity;

    }

    public LoadCapacity getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public String toString() {
        return   loadCapacity + " " +
                  super.toString();
    }

    @Override
    public void startMove() {
        System.out.println("Грузовик марки " + getBrand() + " начал движение ");
    }

    @Override
    public void finishMove() {
        System.out.println("Грузовик марки " + getBrand() + " закончил движение ");
    }
    @Override
    public boolean diagnostic()  throws TransportTypeException {
        System.out.println("Пройти диагностику легкового грузового автомобиля");
        return true;
    }

    @Override
    public Type getType() {
        return Type.TRUCK;
    }

    @Override
    public void printType() {
        if (loadCapacity != null) {
            System.out.println(loadCapacity);
        } else {
            System.out.println("Данных по транспортному средству недостаточно");
        }
    }

    @Override
    public void pitStop() {
        System.out.println("Пит стоп у грузовика");
    }

    @Override
    public void theBestCircleTime() {
        int minBound = 90;
        int maxBound = 140;
        int theBestTimeInMins = (int) (minBound + (maxBound - minBound) + Math.random());

        System.out.println("Лучшее время круга для грузовика " + theBestTimeInMins);
    }

    @Override
    public void maxSpeed() {
        int minBound = 90;
        int maxBound = 130;
        int maxSpeed = (int) (minBound + (maxBound - minBound) + Math.random());
        System.out.println("Максимальная скорость для грузовика " + maxSpeed);
    }
}
