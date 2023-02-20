package Transport;

import Transport.*;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            DriverB driverB = new DriverB(
                    "Driver cat.B №" + i,
                    true,
                    5 + i);
            Car car = new Car(
                    "Car" + i,
                    "A" + i,
                    2000 + i,
                    1.6, driverB, Car.BodyType.VAN,Type.CAR);


            DriverC driverC = new DriverC(
                    "Driver cat.C №" + i,
                    true,
                    7 + i);
            Truck truck = new Truck(
                    "Truck" + i,
                    "A" + i,
                    2000 + i,
                    4.0, driverC, Truck.LoadCapacity.N1,Type.TRUCK);


            DriverD driverD = new DriverD(
                    "Driver cat.D №" + i,
                    true,
                    10 + i);
            Bus bus = new Bus(
                    "Bus" + i,
                    "A" + i,
                    2000 + i,
                    4.5, driverD, Bus.CapacityType.SMALL,Type.BUS);
            printInfo(car);
            printInfo(bus);
            printInfo(truck);
            System.out.println(car);
            System.out.println(truck);
            System.out.println(bus);
            car.printType();
            bus.printType();
            truck.printType();
            checkDiagnostic(car);
            checkDiagnostic(bus);
            checkDiagnostic(truck);
        }
    }

    public static void printInfo(Transport<?> trasport) {
        System.out.println("Водитель " + trasport.getDriver().getName() + " управляет автомобилем " + trasport.getBrand() + " и будет учавствовать в заезде!");
    }
    public static void checkDiagnostic(Transport<?> transport){
        try {
            transport.diagnostic();
        } catch (TransportTypeException e) {
            System.out.println("Автобусы диагностику не должны проходить");
        }
    }
}



