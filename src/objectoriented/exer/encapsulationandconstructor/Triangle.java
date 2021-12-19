package objectoriented.exer.encapsulationandconstructor;

public class Triangle {
    private double base;
    private double height;

    public Triangle(double b, double h) {
        base = b;
        height = h;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double b) {
        base = b;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double h) {
        height = h;
    }
}
