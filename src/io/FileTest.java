package io;

import org.junit.Test;

import java.io.File;
import java.util.Date;
import java.util.Objects;

/*
# `File` 类

- `File` 类的一个对象，代表一个文件或一个文件目录（文件夹）
- `File` 类声明在 `java.io` 包下
 */
public class FileTest {
    /*
    ## 如何创建 `File` 的实例

    - `File(String pathname)`
    - `File(String parent, String child)`
    - `File(File parent, String child)`

    ### 说明

    - 路径
      - 相对路径：相较于某个路径下，指明的路径
      - 绝对路径：包含盘符在内的文件或文件目录的路径
    - 路径分隔符
      - Windows：`\\`
      - UNIX：`/`
     */
    @Test
    public void test1() {
        // 构造器 1
        File file = new File("hello.txt"); // 相对于当前 module
        // 构造器 2
        File file1 = new File(".", "hi");
        // 构造器 3
        File file2 = new File(file1, "hi.txt");

        System.out.println(file);
        System.out.println(file1);
        System.out.println(file2);
    }

    /*
    - `String getAbsolutePath()`：获取绝对目录
    - `String getPath()`：获取路径
    - `String getName()`：获取名称
    - `String getParent()`：获取上层文件目录路径，若无，返回 `null`
    - `long length()`：获取文件长度（即：字节数），不能获取目录的长度
    - `long lastModified()`：获取最后一次的修改时间，毫秒值
    - 如下方法适用于文件目录
      - `String[] list()`：获取指定目录下的所有文件或者文件目录的名称数组
      - `File[] listFiles()`：获取指定目录下的所有文件或者文件目录的 File 数组
     */
    @Test
    public void test2() {
        File file = new File("hello.txt");

        System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
        System.out.println("file.getPath() = " + file.getPath());
        System.out.println("file.getName() = " + file.getName());
        System.out.println("file.getParent() = " + file.getParent());
        System.out.println("file.length() = " + file.length());
        long lastModified = file.lastModified();
        System.out.println("file.lastModified() = " + lastModified);
        System.out.println(new Date(lastModified));

        System.out.println();

        File dir = new File(".");

        int i = 1;
        for (String s : Objects.requireNonNull(dir.list())) {
            System.out.println(i + ": " + s);
            i++;
        }

        System.out.println();

        i = 1;
        for (File listFile : Objects.requireNonNull(dir.listFiles())) {
            System.out.println(i + ": " + listFile);
            i++;
        }

        System.out.println();

        System.out.println("dir.getAbsolutePath() = " + dir.getAbsolutePath());
        System.out.println("dir.getPath() = " + dir.getPath());
        System.out.println("dir.getName() = " + dir.getName());
        System.out.println("dir.getParent() = " + dir.getParent());
        System.out.println("dir.length() = " + dir.length());
        long lastModified1 = dir.lastModified();
        System.out.println("dir.lastModified() = " + lastModified1);
        System.out.println(new Date(lastModified1));
    }

    /*
    - `boolean renameTo(File dest)`
      - 把文件重命名为指定的文件路径
      - 以 `file1.renameTo(file2)` 为例
        - 要想要返回 `true`，需要 `file1` 在硬盘中是存在的，且 `file2` 在硬盘中不存在
     */
    @Test
    public void test3() {
        File file1 = new File("hellojava.txt");
        File file2 = new File("helloworld.txt");

        boolean isRenameTo = file1.renameTo(file2);
        System.out.println(isRenameTo);

        if (!isRenameTo) {
            System.out.println(file2.renameTo(file1));
        }
    }
}
