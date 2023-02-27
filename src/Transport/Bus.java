package Transport;
import java.util.List;
import java.util.Set;

public class Bus extends Transport<DriverD> {

    private final CapacityType capacityType;

    enum CapacityType {
        EXTRA_SMALL(null, 10),
        SMALL(null, 25),
        MEDIUM(25, 50),
        LARGE(50, 80),
        ESPECIALLY_LARGE(80, 120);

        private final Integer lowerLimitsOfCapacity;
        private final Integer upperLimitsOfCapacity;

        CapacityType(Integer lowerLimitsOfCapacity, Integer upperLimitsOfCapacity) {
            this.lowerLimitsOfCapacity = lowerLimitsOfCapacity;
            this.upperLimitsOfCapacity = upperLimitsOfCapacity;
        }

        public Integer getLowerLimitsOfCapacity() {
            return lowerLimitsOfCapacity;
        }

        public Integer getUpperLimitsOfCapacity() {
            return upperLimitsOfCapacity;
        }

        @Override
        public String toString() {
            return "Вместимость: " +
                    (getLowerLimitsOfCapacity() == null ? "" : "от " + getLowerLimitsOfCapacity() + "") +
                    (getUpperLimitsOfCapacity() == null ? "" : " до " + getUpperLimitsOfCapacity() + "");
        }
    }


    public Bus(String brand, String model, double engineVolume, DriverD driver, CapacityType capacityType, Type type, List<Mechanic> mechanics) {
        super(brand, model, engineVolume, driver, type, mechanics);
        this.capacityType = capacityType;
    }

    public CapacityType getCapacityType() {
        return capacityType;
    }

    @Override
    public String toString() {
        return capacityType + " " +
                super.toString();
    }

    @Override
    public void startMove() {
        System.out.println("Автобус марки " + getBrand() + " начал движение ");
    }

    @Override
    public void finishMove() {
        System.out.println("Автобус марки " + getBrand() + " закончил движение ");
    }

    @Override
    public boolean diagnostic() throws TransportTypeException {
        throw new TransportTypeException("Автобусы диагностику не проходят");

    }

    @Override
    public Type getType() {
        return Type.BUS;
    }

    @Override
    public void printType() {
        if (capacityType != null) {
            System.out.println("Автобус: " + capacityType);
        } else {
            System.out.println("Данных по транспортному средству недостаточно");
        }
    }

    @Override
    public void pitStop() {
        System.out.println("Пит стоп у автобуса");
    }

    @Override
    public void theBestCircleTime() {
        int minBound = 100;
        int maxBound = 150;
        int theBestTimeInMins = (int) (minBound + (maxBound - minBound) + Math.random());

        System.out.println("Лучшее время круга " + theBestTimeInMins);
    }

    @Override
    public void maxSpeed() {
        int minBound = 80;
        int maxBound = 120;
        int maxSpeed = (int) (minBound + (maxBound - minBound) + Math.random());
        System.out.println("Максимальная скорость для автобуса " + maxSpeed);
    }
}

