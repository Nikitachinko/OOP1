package Transport;

public abstract class Transport<T extends Driver> implements Competing{
    private  final String brand;
    private  final String model;
    private  double engineVolume;
    private T driver;
    private Type type;


    public Transport(String brand,
                     String model,
                     int year,
                     double engineVolume,
                     T driver,Type type) {
        if (brand == null || brand.isEmpty()) {
            brand = "defoult";
        }
        this.brand = brand;
        if (model == null || model.isEmpty()) {
            model = "defoult";
        }
        this.model = model;
        if (year <= 0) {
            year = 2000;
        }
        setEngineVolume(engineVolume);
        setDriver(driver);
        this.type=type;

    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        if(engineVolume<=0){
            engineVolume=1.6;
        }
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
    public abstract void diagnostic() throws TransportTypeException;


    public void printInfo(){
        System.out.println("Водитель " + driver.getName() + " управляет автомобилем ");
    }

    @Override
    public String toString() {
        return "Марка машины " + brand + " " +
                "Модель " + model + " " +
                "Объем двигателя  " + engineVolume;


    }
}
