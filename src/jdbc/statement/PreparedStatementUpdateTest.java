package jdbc.statement;

import jdbc.util.JDBCUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

/*
# PreparedStatement

- 使用 `PreparedStatement` 替换 `Statement` 实现对数据表的增删改查操作
 */
public class PreparedStatementUpdateTest {
    // 向 Customers 表中添加一条记录
    @Test
    public void test1() {
        Properties properties = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/jdbc/jdbc.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        PreparedStatement ps = null;
        Connection conn = null;
        try {
            // 加载驱动
            DriverManager.registerDriver(
                    (Driver) Class.
                            forName(properties.getProperty("driver")).
                            getDeclaredConstructor().
                            newInstance()
            );

            // 获取连接
            conn = DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("user"),
                    properties.getProperty("password")
            );

            // 预编译 SQL 语句
            String sql = "INSERT INTO customers(`name`, email, birth) VALUES (?, ?, ?)";
            ps = conn.prepareStatement(sql);

            // 填充占位符
            ps.setString(1, "icekylin");
            ps.setString(2, "icekylin@gmail.com");
            ps.setDate(
                    3,
                    new java.sql.Date(
                            new SimpleDateFormat("yyyy-MM-dd").
                                    parse("2002-07-02").
                                    getTime()
                    )
            );

            // 执行操作
            ps.execute();
        } catch (SQLException |
                 InstantiationException |
                 IllegalAccessException |
                 InvocationTargetException |
                 NoSuchMethodException |
                 ClassNotFoundException |
                 ParseException e) {
            e.printStackTrace();
        } finally {
            // 资源的关闭
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 修改 Customers 表中的一条记录
    @Test
    public void test2() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1. 获取数据库的连接
            conn = JDBCUtils.getConnection();

            // 2. 预编译 SQL 语句，返回 PreparedStatement 的实例
            String sql = "UPDATE customers SET `name` = ? WHERE id = ?";
            ps = conn.prepareStatement(sql);

            // 3. 填充占位符
            ps.setString(1, "莫扎特");
            ps.setInt(2, 18);

            // 4. 执行
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5. 资源的关闭
            JDBCUtils.closeResources(conn, ps);
        }
    }

    // 删除 Customers 表中的一条记录
    @Test
    public void test3() {
        String sql = "DELETE FROM customers WHERE id = ?";
        JDBCUtils.update(sql, 3);
    }

    // 修改 Order 表中的一条记录
    @Test
    public void test4() {
        String sql = "UPDATE `order` SET `order`.order_name = ? WHERE `order`.order_id = ?";
        JDBCUtils.update(sql, "DD", 2);
    }
}
