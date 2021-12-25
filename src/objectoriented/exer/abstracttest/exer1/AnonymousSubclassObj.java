package objectoriented.exer.abstracttest.exer1;

public class AnonymousSubclassObj {
    public static void main(String[] args) {
        m1(new Employee() {
            @Override
            public void work() {
                System.out.println("摸鱼...");
            }
        });
    }

    public static void m1(Employee e) {
        e.work();
    }
}
