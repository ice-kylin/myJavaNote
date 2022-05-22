package jdbc.connection;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {
    // 方式 1
    @Test
    public void test1() throws SQLException {
        // 1. 获取 Driver 实现类对象
        Driver driver = new com.mysql.cj.jdbc.Driver();

        // 2. 提供要连接的数据库
        /*
        - url
          - `jdbc:mysql`：协议
          - `localhost`：IP 地址
          - `3306`：端口号
          - `test`：数据库名
         */
        String url = "jdbc:mysql://localhost:3306/test";
        // 3. 提供连接需要的用户名和密码
        // 将用户名和密码封装在 Properties 中
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "Root2333");

        // 4. 获取连接
        Connection connection = driver.connect(url, info);

        System.out.println(connection);
    }

    // 方式 2：在程序中不出现第三方的 API，使得程序具有更好的可移植性
    @Test
    public void test2() throws
            ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            NoSuchMethodException,
            InvocationTargetException, SQLException {
        // 1. 获取 Driver 实现类对象：使用反射
        Class<?> clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.getDeclaredConstructor().newInstance();

        // 2. 提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/test";
        // 3. 提供连接需要的用户名和密码
        // 将用户名和密码封装在 Properties 中
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "Root2333");

        // 4. 获取连接
        Connection connection = driver.connect(url, info);

        System.out.println(connection);
    }

    // 方式 3：使用 DriverManager 替换 Driver
    @Test
    public void test3() throws
            ClassNotFoundException,
            SQLException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
        // 1. 获取 Driver 实现类对象
        Class<?> clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.getDeclaredConstructor().newInstance();

        // 2. 提供另外三个连接的基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String name = "root";
        String passwd = "Root2333";

        // 注册驱动
        DriverManager.registerDriver(driver);

        // 3. 获取连接
        Connection connection = DriverManager.getConnection(url, name, passwd);

        System.out.println(connection);
    }

    // 方式 4：可以只是加载驱动，不用显式地注册驱动了
    @Test
    public void test4() throws
            ClassNotFoundException,
            SQLException {
        // 1. 提供另外三个连接的基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String name = "root";
        String passwd = "Root2333";

        // 2. 加载 Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        /*
        - 为什么可以省略
          - ```java
            static {
                try {
                    java.sql.DriverManager.registerDriver(new Driver());
                } catch (SQLException E) {
                    throw new RuntimeException("Can't register driver!");
                }
            }
            ```
         */

        // 3. 获取连接
        Connection connection = DriverManager.getConnection(url, name, passwd);

        System.out.println(connection);
    }

    // 方式 5
    @Test
    public void test5() throws
            SQLException {
        // 1. 提供另外三个连接的基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String name = "root";
        String passwd = "Root2333";

        // 2. 获取连接
        Connection connection = DriverManager.getConnection(url, name, passwd);

        System.out.println(connection);
    }

    /*
    - 方式 6：将数据库连接需要的 4 个基本信息声明在配置文件当中，通过读取配置文件的方式获取连接
      - 好处
        - 实现了数据与代码的分离，实现了解耦
        - 如果需要修改配置文件信息，可以避免程序重新打包
     */
    @Test
    public void test6() throws
            ClassNotFoundException,
            SQLException {
        // 1. 读取配置文件中的 4 个基本信息
        File file = new File("src/jdbc/jdbc.properties");

        Properties properties;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);

            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        // 2. 加载驱动
        Class.forName(driver);

        // 3. 获取连接
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);
    }
}
