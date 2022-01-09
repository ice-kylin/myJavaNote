package online.icekylin.teamview.domain;

public class Designer extends Programmer {
    private double bonus;

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return String.format("%2d", getId()) +
                "\t\t" + String.format("%4s", getName()) +
                "\t\t" + String.format("%2d", getAge()) +
                "\t\t" + String.format("%8.2f", getSalary()) +
                "\t\t" + "设计师" +
                "\t\t" + String.format("%8s", getStatus().getNAME()) +
                "\t\t" + String.format("%8.2f", bonus) +
                String.format("\t\t%5s\t\t", "") +
                getEquipment().getDescription();
    }
}
