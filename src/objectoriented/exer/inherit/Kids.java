package objectoriented.exer.inherit;

public class Kids extends ManKind {
    private int yearsOld;

    public Kids() {
    }

    public Kids(int sex, int salary, int yearsOld) {
        super(sex, salary);
        this.yearsOld = yearsOld;
    }

    public Kids printAge() {
        System.out.println("I am " + yearsOld + " years old.");

        return this;
    }
}
