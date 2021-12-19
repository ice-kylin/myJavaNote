package objectoriented.exer.thisexer;

public class BoyAndGirlTest {
    public static void main(String[] args) {
        Boy b1 = new Boy("Dupi", 19);
        Girl g1 = new Girl("Acker", 19);
        Girl g2 = new Girl("Cornelia", 25);

        b1.marry(g1);

        System.out.println();

        b1.shout();

        System.out.println(g1.compare(g2));
    }
}
