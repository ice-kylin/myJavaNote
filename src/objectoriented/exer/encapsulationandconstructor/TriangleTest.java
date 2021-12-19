package objectoriented.exer.encapsulationandconstructor;

public class TriangleTest {
    public static void main(String[] args) {
        Triangle t1 = new Triangle(10, 20);

        System.out.println("t1.getBase() = " + t1.getBase());
        System.out.println("t1.getHeight() = " + t1.getHeight());
    }
}
