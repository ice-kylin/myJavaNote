package jdbc.statement;

import jdbc.bean.Customer;
import jdbc.bean.Order;
import jdbc.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

public class QueryForCustomerTest {
    @Test
    public void test1() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();

            String sql = "SELECT id, `name`, email, birth FROM customers WHERE id = ?";
            ps = conn.prepareStatement(sql);

            // 填充占位符
            ps.setInt(1, 1);

            // 执行并返回结果集
            resultSet = ps.executeQuery();

            // 处理结果集
            if (resultSet.next()) { // 判断结果集的下一条是否有数据，如果有数据，返回 true 并下移指针；如果返回 false 指针不会下移
                // 获取当前数据的各个字段值
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);

                Customer customer = new Customer(id, name, email, birth);

                System.out.println(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            JDBCUtils.closeResources(conn, ps, resultSet);
        }
    }

    // 针对 customers 表的通用的查询操作
    public Customer queryForCustomers(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Customer customer = null;
        try {
            conn = JDBCUtils.getConnection();

            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            resultSet = ps.executeQuery();
            // 获取结果集的元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            if (resultSet.next()) {
                customer = new Customer();

                // 处理结果集一行数据中的每一个列
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = resultSet.getObject(i + 1);
                    // 获取每个列的列名
                    String columnName = metaData.getColumnName(i + 1);

                    // 给 customer 对象指定的某个属性赋值为 columnValue（通过反射）
                    try {
                        Field field = Customer.class.getDeclaredField(columnName);
                        field.setAccessible(true);
                        field.set(customer, columnValue);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn, ps, resultSet);
        }

        return customer;
    }

    @Test
    public void test2() {
        String sql = "SELECT id, `name`, email, birth FROM customers WHERE id = ?";
        Customer customer = queryForCustomers(sql, 13);
        System.out.println(customer);

        sql = "SELECT `name`, email FROM customers WHERE `name` = ?";
        customer = queryForCustomers(sql, "周杰伦");
        System.out.println(customer);
    }
}
