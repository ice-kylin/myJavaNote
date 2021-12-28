package objectoriented.exer.interfacetest;

public class CompareableCircle extends Circle implements CompareObject {
    public CompareableCircle() {
    }

    public CompareableCircle(int radius) {
        super(radius);
    }

    @Override
    public int compareTo(Object o) {
        if (o == this) {
            return 0;
        } else if (o instanceof CompareableCircle) {
            CompareableCircle c = (CompareableCircle) o;
            return getRadius() - c.getRadius();
        } else {
            return 0;
        }
    }
}
