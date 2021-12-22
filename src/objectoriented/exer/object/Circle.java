package objectoriented.exer.object;

public class Circle extends GeometricObject {
    private double radius;

    public Circle() {
        radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, double weight, double radius) {
        super(color, weight);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double findArea() {
        return Math.PI * radius * radius;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else {
            if (o instanceof Circle) {
                Circle c = (Circle) o;
                return radius == c.radius;
            } else {
                return false;
            }
        }
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
