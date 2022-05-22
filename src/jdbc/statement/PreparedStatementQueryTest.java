package jdbc.statement;

import jdbc.bean.Customer;
import jdbc.bean.Order;
import jdbc.util.JDBCUtils;
import org.junit.Test;

import java.util.ArrayList;

public class PreparedStatementQueryTest {
    @Test
    public void test1() {
        String sql = "SELECT id, `name`, email FROM customers WHERE id = ?";
        Customer customer = JDBCUtils.query(Customer.class, sql, 12);
        System.out.println(customer);

        sql = "SELECT order_id, order_name FROM `order` WHERE order_id = ?";
        Order order = JDBCUtils.query(Order.class, sql, 1);
        System.out.println(order);
    }

    @Test
    public void test2() {
        String sql = "SELECT id, `name`, email FROM customers WHERE id < ?";
        ArrayList<Customer> customers = JDBCUtils.query2(Customer.class, sql, 12);
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        System.out.println();

        sql = "SELECT id, `name`, email FROM customers";
        for (Customer customer : JDBCUtils.query2(Customer.class, sql)) {
            System.out.println(customer);
        }

        System.out.println();

        sql = "SELECT order_id, order_name FROM `order` WHERE order_id < ?;";
        for (Order order : JDBCUtils.query2(Order.class, sql, 5)) {
            System.out.println(order);
        }
    }
}
