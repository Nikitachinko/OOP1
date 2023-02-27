package Transport;


import java.util.List;
import java.util.ArrayList;



public abstract class Transport<T extends Driver> implements Competing{
    private  final String brand;
    private  final String model;
    private  double engineVolume;
    private T driver;
    private Type type;

    private List<Mechanic> mechanics = new ArrayList<>();



    public Transport(String brand, String model,  double engineVolume, T driver,Type type,List<Mechanic> mechanics) {
//        if (brand == null || brand.isEmpty()) {
//            brand = "defoult";
//        }
        this.brand = brand;
//        if (model == null || model.isEmpty()) {
//            model = "defoult";
//        }
        this.model = model;
this.driver=driver;
this.engineVolume=engineVolume;
        setEngineVolume(engineVolume);
        setDriver(driver);
        this.type=type;
        this.mechanics = mechanics;

    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
    public List<Mechanic> getMechanics() {
        return mechanics;
    }

    public void setMechanics(List<Mechanic> mechanics) {
        this.mechanics = mechanics;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
//        if(engineVolume<=0){
//            engineVolume=1.6;
//        }
        this.engineVolume = engineVolume;
    }

    public T getDriver() {
        return driver;
    }

    public void setDriver(T driver) {
        this.driver = driver;
    }

    public abstract void startMove();
    public abstract void finishMove();

    public abstract Type getType();
    public abstract void printType();
    public abstract boolean diagnostic() throws TransportTypeException;
    public void transportHaveMechanic(){
        System.out.println(getType() + " " + getMechanics());
    }

    public void nameDriverTransport(){
        System.out.println(getType() + " " + driver.getName());
    }

    public void printInfo(){
        System.out.println("Водитель " + getDriver() + " управляет автомобилем " + getBrand() + " и будет участвовать в заезде");
    }



    @Override
    public String toString() {
        return "Марка машины " + brand + " " +
                "Модель " + model + " " +
                "Объем двигателя  " + engineVolume+
                ", Водитель " + driver +
                ". Механик " + mechanics;


    }
}
