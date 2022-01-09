package online.icekylin.teamview.domain;

public class Architect extends Designer {
    private int stock;

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format("%2d", getId()) +
                "\t\t" + String.format("%4s", getName()) +
                "\t\t" + String.format("%2d", getAge()) +
                "\t\t" + String.format("%8.2f", getSalary()) +
                "\t\t" + "架构师" +
                "\t\t" + String.format("%8s", getStatus().getNAME()) +
                "\t\t" + String.format("%8.2f", getBonus()) +
                "\t\t" + String.format("%5d", stock) +
                "\t\t" + getEquipment().getDescription();
    }

    @Override
    public String toTeamInfoString() {
        return String.format("%5s", getMemberId() + "/" + getId()) +
                "\t\t" + String.format("%4s", getName()) +
                "\t\t" + String.format("%2d", getAge()) +
                "\t\t" + String.format("%8.2f", getSalary()) +
                "\t\t" + "架构师" +
                "\t\t" + String.format("%8.2f", getBonus()) +
                "\t\t" + String.format("%5d", stock);
    }
}
