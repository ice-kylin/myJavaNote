package jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class JDBCUtils {
    /**
     * @Description 获取数据库连接
     */
    public static Connection getConnection() throws SQLException {
        Properties properties = new Properties();

        InputStream is = null;
        try {
            is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc/jdbc.properties");
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            DriverManager.registerDriver(
                    (Driver) Class.
                            forName(properties.getProperty("driver")).
                            getDeclaredConstructor().
                            newInstance()
            );
        } catch (InstantiationException |
                 ClassNotFoundException |
                 NoSuchMethodException |
                 InvocationTargetException |
                 IllegalAccessException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("user"),
                properties.getProperty("password")
        );
    }

    /**
     * @Description 关闭连接和 Statement
     */
    public static void closeResources(Connection conn, Statement statement) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @Description 关闭连接、Statement 和 ResultSet
     */
    public static void closeResources(Connection conn, Statement statement, ResultSet resultSet) {
        closeResources(conn, statement);

        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description 增删改通用操作
     */
    public static void update(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1. 数据库的连接
            conn = getConnection();

            // 2. 预编译 SQL 语句，返回 PreparedStatement 的实例
            ps = conn.prepareStatement(sql);

            // 3. 填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            // 4. 执行
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭连接
            closeResources(conn, ps);
        }
    }

    /**
     * @Description 查询通用操作（返回一条记录）
     */
    public static <T> T query(Class<T> clazz, String sql, Object... args) {
        T t = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            int i = 0;
            for (Object arg : args) {
                ps.setObject(i + 1, arg);
            }

            rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int cc = md.getColumnCount();

            if (rs.next()) {
                t = clazz.getDeclaredConstructor().newInstance();

                for (int j = 0; j < cc; j++) {
                    Object cv = rs.getObject(j + 1);

                    Field field = clazz.getDeclaredField(sqlColumnNameToJavaName(md.getColumnName(j + 1)));
                    field.setAccessible(true);
                    field.set(t, cv);
                }
            }
        } catch (SQLException |
                 InstantiationException |
                 IllegalAccessException |
                 InvocationTargetException |
                 NoSuchMethodException |
                 NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, ps, rs);
        }

        return t;
    }

    /**
     * @Description 查询通用操作（返回多条记录）
     */
    public static <T> ArrayList<T> query2(Class<T> clazz, String sql, Object... args) {
        ArrayList<T> ts = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            int i = 0;
            for (Object arg : args) {
                ps.setObject(i + 1, arg);
            }

            rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int cc = md.getColumnCount();

            Constructor<T> constructor = clazz.getDeclaredConstructor();
            T t;
            Object cv;
            Field field;
            while (rs.next()) {
                t = constructor.newInstance();

                for (int j = 0; j < cc; j++) {
                    cv = rs.getObject(j + 1);

                    field = clazz.getDeclaredField(sqlColumnNameToJavaName(md.getColumnName(j + 1)));
                    field.setAccessible(true);
                    field.set(t, cv);
                }

                ts.add(t);
            }
        } catch (SQLException |
                 InstantiationException |
                 IllegalAccessException |
                 InvocationTargetException |
                 NoSuchMethodException |
                 NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, ps, rs);
        }

        return ts;
    }

    public static String sqlColumnNameToJavaName(String columnName) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        for (String s : columnName.split("_")) {
            if (i != 0) {
                sb.append(s.substring(0, 1).toUpperCase())
                        .append(s.substring(1));
            } else {
                sb.append(s);
            }

            i++;
        }

        return sb.toString();
    }
}
