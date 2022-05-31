package reflection.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
# 动态代理

- 如何根据加载到内存中的被代理类，动态的创建一个代理类的对象
- 当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法
 */
interface Human {
    String getBelief();

    void eat(String food);
}

class Superman implements Human {
    @Override
    public String getBelief() {
        return "I can fly.";
    }

    @Override
    public void eat(String food) {
        System.out.println("Superman is eating " + food + ".");
    }
}

class ProxyFactory {
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler handler = new MyInvocationHandler(obj);

        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                handler
        );
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object obj;

    public MyInvocationHandler(Object obj) {
        bind(obj);
    }

    public void bind(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(
            Object proxy,
            Method method, // 即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
            Object[] args
    ) throws Throwable {
        return method.invoke(
                obj, // 被代理类对象
                args
        ); // 方法的返回值就作为当前类中的 invoke() 方法的返回值
    }
}

public class ProxyTest {
    @Test
    public void test1() throws ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
        Class<?> clazz = Class.forName(
                "reflection.proxy.Superman"
        );
        Object instance = clazz
                .getDeclaredConstructor()
                .newInstance();

        Human proxyHuman = (Human) ProxyFactory
                .getProxyInstance(instance); // 代理类的对象

        // 当通过代理类的对象调用方法时，会自动地调用被代理类中同名的方法
        System.out.println(proxyHuman.getBelief());
        proxyHuman.eat("Hamburger");

        System.out.println();

        clazz = Class.forName(
                "reflection.proxy.BYDFactory"
        );
        instance = clazz
                .getDeclaredConstructor()
                .newInstance();

        CarFactory proxyCarFactory = (CarFactory) ProxyFactory
                .getProxyInstance(instance);

        proxyCarFactory.produceCar();
    }
}
