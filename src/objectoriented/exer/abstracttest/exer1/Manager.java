package objectoriented.exer.abstracttest.exer1;

public class Manager extends Employee {
    private double bonus;

    public Manager() {
    }

    public Manager(int bonus) {
        this.bonus = bonus;
    }

    public Manager(String name, int id, double salary, int bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("乱指挥");
    }
}
