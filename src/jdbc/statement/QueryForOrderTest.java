package jdbc.statement;

import jdbc.bean.Order;
import jdbc.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

public class QueryForOrderTest {
    // 针对 orders 表的通用的查询操作
    public Order queryForOrders(String sql, Object... args) {
        Order order = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();

            ps = conn.prepareStatement(sql);

            int i = 0;
            for (Object arg : args) {
                ps.setObject(++i, arg);
            }

            rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            if (rs.next()) {
                order = new Order();

                Object columnValue;
                String columnName;
                Field field;
                for (i = 0; i < columnCount; i++) {
                    columnValue = rs.getObject(i + 1);
                    columnName = metaData.getColumnName(i + 1);

                    try {
                        field = Order.class.getDeclaredField(JDBCUtils.sqlColumnNameToJavaName(columnName));
                        field.setAccessible(true);
                        field.set(order, columnValue);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn, ps, rs);
        }

        return order;
    }



    @Test
    public void test1() {
        String sql = "SELECT order_id, order_name, order_date FROM `order` WHERE order_id = ?";
        Order order = queryForOrders(sql, 1);
        System.out.println(order);
    }
}
