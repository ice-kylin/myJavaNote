package overview;

/**
 * 文档注释
 *
 * @author icekylin
 * @version 1.0.0
 * <p>
 * 学习注释的笔记
 */
/*
# 语言概述.注释

## 分类

- 单行注释
- 多行注释
  - 多行注释不可以嵌套使用
- 文档注释

## 作用

1. 对所写的程序进行解释说明，增强可读性
2. 调试所写代码

## 特点

- 被单行注释和多行注释注释了的内容不参与编译
- 换句话说，编译以后的 `.class` 结尾的字节码文件中不包含注释掉的信息

## 文档注释

注释的内容可以被 JDK 提供的工具 `javadoc` 所解析，生成一套以网页文件形式体现的该程序的说明文档

```
javadoc -d 文件夹名字 -author -version 文件名.java
```
 */
public class Annotation {
    /**
     * main() 方法
     */
    public static void main(String[] args) {
        // 单行注释
        /*
         * 多行注释
         * */
        System.out.println("Hello World!");
    }
}
