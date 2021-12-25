package objectoriented.exer.abstracttest.exer2;

public class HourlyEmployee extends Employee {
    private double wage;
    private double hour;

    public HourlyEmployee() {
    }

    public HourlyEmployee(double wage, double hour) {
        this.wage = wage;
        this.hour = hour;
    }

    public HourlyEmployee(String name, int number, MyDate birthday, double wage, double hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    public double earnings() {
        return wage * hour;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "name='" + getName() + '\'' +
                ", number=" + getNumber() +
                ", birthday=" + getBirthday().toDateString() +
                ", wage=" + wage +
                ", hour=" + hour +
                '}';
    }
}
