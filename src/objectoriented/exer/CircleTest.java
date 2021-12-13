package objectoriented.exer;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.radius = 10;

        System.out.println("circle.calcArea() = " + circle.calcArea());
    }
}

class Circle {
    double radius;

    public double calcArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
