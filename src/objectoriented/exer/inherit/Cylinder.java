package objectoriented.exer.inherit;

public class Cylinder extends Circle {
    private double length;

    public Cylinder() {
        length = 1.0;
    }

    public Cylinder(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double findVolume() {
        return findArea() * length;
    }
}
