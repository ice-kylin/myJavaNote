package objectoriented.exer;

public class PassObjectTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        PassObject passObject = new PassObject();

        passObject.printAreas(circle, 5);
    }
}

class PassObject {
    public void printAreas(Circle c, int time) {
        System.out.println("Radius\t\tArea");

        for (int i = 1; i <= time; i++) {
            c.radius = i;
            System.out.println(c.radius + "\t\t\t" + c.calcArea());
        }

        System.out.println("\nNow radius is: " + ++c.radius);
    }
}
