package Transport;

import java.util.Objects;


public class Mechanic {
    private final String name;
    private String company;

    public Mechanic(String name, String company) {
        this.name = name;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    public void carryOutMaintenance(){
        System.out.println("Провести техобслуживание");
    }
    public void fixTheCar(){
        System.out.println("Починить машину");
    }

    @Override
    public String toString() {
        return "Фамилия, Имя: " + name +
                ", компания " + company;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic mechanic = (Mechanic) o;
        return Objects.equals(name, mechanic.name) && Objects.equals(company, mechanic.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, company);
    }
}
