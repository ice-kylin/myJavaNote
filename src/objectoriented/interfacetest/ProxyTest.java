package objectoriented.interfacetest;

interface Network {
    void browse();
}

/*
# 代理模式
 */
public class ProxyTest {
    public static void main(String[] args) {
        ProxyServer p = new ProxyServer(new RealServer());
        p.browse();
    }
}

class RealServer implements Network {
    @Override
    public void browse() {
        System.out.println("上网...");
    }
}

class ProxyServer implements Network {
    private final Network network;

    public ProxyServer() {
        network = new RealServer();
    }

    public ProxyServer(Network network) {
        this.network = network;
    }

    public void check() {
        System.out.println("检查...");
    }

    @Override
    public void browse() {
        check();
        network.browse();
    }
}
