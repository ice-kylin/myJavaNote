package reflection.proxy;

import org.junit.Test;

/*
# 静态代理

- 特点：代理类和被代理类在编译期间就确定下来了
 */
interface CarFactory {
    void produceCar();
}

class ProxyCarFactory implements CarFactory {
    private final CarFactory factory;

    public ProxyCarFactory(CarFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCar() {
        System.out.println("生产前的准备工作...");
        factory.produceCar();
        System.out.println("生产后的收尾工作...");
    }
}

class BYDFactory implements CarFactory {
    @Override
    public void produceCar() {
        System.out.println("BYD cars are produced.");
    }
}

public class StaticProxyTest {
    @Test
    public void test1() {
        CarFactory bydFactory = new BYDFactory();
        CarFactory factory = new ProxyCarFactory(bydFactory);

        factory.produceCar();
    }
}
