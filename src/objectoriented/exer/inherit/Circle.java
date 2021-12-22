package objectoriented.exer.inherit;

public class Circle {
    private double radius;

    public Circle() {
        radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public Circle setRadius(double radius) {
        this.radius = radius;

        return this;
    }

    public double findArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
