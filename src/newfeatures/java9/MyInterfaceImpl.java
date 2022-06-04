package newfeatures.java9;

public class MyInterfaceImpl implements MyInterface {
    public static void main(String[] args) {
        // 接口中的静态方法只能由接口自己调用
        MyInterface.methodStatic();

        MyInterfaceImpl myInterface = new MyInterfaceImpl();

        myInterface.methodDefault();
    }

    @Override
    public void methodAbstract() {
        System.out.println("我是实现类中实现的抽象方法...");
    }

    @Override
    public void methodDefault() {
        MyInterface.super.methodDefault();
        System.out.println("我是实现类中重写的默认方法...");
    }
}
