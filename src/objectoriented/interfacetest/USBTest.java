package objectoriented.interfacetest;

interface USB {
    void start();

    void stop();
}

/*
# 接口的使用

- 接口使用上也满足多态性
- 接口实际上就是定义了一种规范
- 开发中体会面向接口编程
 */
public class USBTest {
    public static void main(String[] args) {
        Computer c = new Computer();
        Printer p = new Printer(); // 创建了接口的非匿名实现类的非匿名对象
        Flash f = new Flash();

        c.transferData(p);
        c.transferData(f);

        c.transferData(new Flash()); // 创建了接口的非匿名实现类的匿名对象

        // 创建了接口的匿名实现类的非匿名对象
        USB u = new USB() {
            @Override
            public void start() {
                System.out.println("不知名设备 1 开始工作");
            }

            @Override
            public void stop() {
                System.out.println("不知名设备 1 结束工作");
            }
        };

        c.transferData(u);

        c.transferData(new USB() {
            @Override
            public void start() {
                System.out.println("不知名设备 2 开始工作");
            }

            @Override
            public void stop() {
                System.out.println("不知名设备 2 结束工作");
            }
        }); // 创建了接口的匿名实现类的非匿名对象
    }
}

class Computer {
    public void transferData(USB u) {
        u.start();

        System.out.println("传输数据...");

        u.stop();
    }
}

class Flash implements USB {
    @Override
    public void start() {
        System.out.println("U 盘开始工作");
    }

    @Override
    public void stop() {
        System.out.println("U 盘结束工作");
    }
}

class Printer implements USB {
    @Override
    public void start() {
        System.out.println("打印机开始工作");
    }

    @Override
    public void stop() {
        System.out.println("打印机结束工作");
    }
}
