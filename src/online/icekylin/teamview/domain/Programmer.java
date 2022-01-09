package online.icekylin.teamview.domain;

import online.icekylin.teamview.service.Status;

public class Programmer extends Employee {
    private int memberId;
    private Status status;
    private Equipment equipment;

    public Programmer() {
        status = Status.FREE;
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
        status = Status.FREE;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return super.toString() + "\t\t"
                + "程序员" + "\t\t"
                + String.format("%8s", status.getNAME())
                + String.format("\t\t%8s\t\t%5s\t\t", "", "")
                + getEquipment().getDescription();
    }

    public String toTeamInfoString() {
        return String.format("%5s", memberId + "/" + getId()) +
                "\t\t" + String.format("%4s", getName()) +
                "\t\t" + String.format("%2d", getAge()) +
                "\t\t" + String.format("%8.2f", getSalary()) +
                "\t\t" + "程序员";
    }
}
