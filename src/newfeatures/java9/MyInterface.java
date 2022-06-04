package newfeatures.java9;

public interface MyInterface {
    static void methodStatic() {
        System.out.println("我是接口中的静态方法...");
    }

    // 如下三个方法的权限修饰符都是 public
    void methodAbstract();

    default void methodDefault() {
        System.out.println("我是接口中的默认方法...");
        methodPrivate();
    }

    // JDK 9 中允许接口中定义私有的方法
    private void methodPrivate() {
        System.out.println("我是接口中的私有方法...");
    }
}
