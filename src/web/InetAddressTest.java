package web;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
# 通信要素一：IP 和端口号

- IP：唯一的表示 Internet 上的计算机
  - 在 Java 中使用 `InetAddress` 类代表 IP
  - IP 分类
    - IPv4 和 IPv6
    - 万维网和局域网
  - 域名
  - 本地回路地址
    - `127.0.0.1`
    - 对应着 `localhost`
  - 如何实例化 `InetAddress`
    - `InetAddress getByName(String host)`
    - `InetAddress getLocalHost()`
  - 两个常用方法
    - `String getHostName()`
    - `String getHostAddress()`
- 端口号
  - 正在计算机上运行的进程
  - 要求：不同的进程有不同的端口号
  - 范围：0 ~ 65535
- 端口号和与 IP 地址的组合得出一个网络套接字 Socket
 */
public class InetAddressTest {
    @Test
    public void test1() {
        try {
            InetAddress inetAddress1 = InetAddress.getByName("192.168.1.1");
            InetAddress inetAddress2 = InetAddress.getByName("www.google.com");
            InetAddress inetAddress3 = InetAddress.getByName("127.0.0.1");
            InetAddress inetAddress4 = InetAddress.getByName("localhost");
            InetAddress localHost = InetAddress.getLocalHost();

            System.out.println(inetAddress1);
            System.out.println(inetAddress2);
            System.out.println(inetAddress3);
            System.out.println(inetAddress4);
            System.out.println(localHost);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            InetAddress inetAddress1 = InetAddress.getByName("www.bing.com");

            System.out.println(inetAddress1.getHostName());
            System.out.println(inetAddress1.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
