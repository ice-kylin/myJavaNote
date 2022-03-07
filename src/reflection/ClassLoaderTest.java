package reflection;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
# 类的加载器
 */
public class ClassLoaderTest {
    @Test
    public void test1() {
        // 对于自定义类，使用系统类加载器进行加载
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        System.out.println(loader);
        // 调用系统类加载器的 `getParent()` 方法获取扩展类加载器
        ClassLoader loader1 = loader.getParent();
        System.out.println(loader1);
        // 调用扩展类加载器的 `getParent()` 方法无法获取引导类加载器
        // 引导类加载器主要负责加载 Java 的核心类库，无法加载自定义类
        ClassLoader loader2 = loader1.getParent();
        System.out.println(loader2);
    }

    @Test
    public void test2() {
        Properties p = new Properties();

        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(
                    new FileInputStream("reflectiontest/jdbc.properties")
            );

            p.load(bis);

            System.out.println("user = " + p.getProperty("user"));
            System.out.println("password = " + p.getProperty("password"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test3() {
        Properties p = new Properties();

        InputStream is = null;
        try {
            is = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");

            p.load(is);

            System.out.println("user = " + p.getProperty("user"));
            System.out.println("password = " + p.getProperty("password"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
