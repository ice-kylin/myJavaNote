package collectionmap;

/*
# 集合

## 集合框架的概述

- 集合、数组都是对多个数据进行存储操作的结构，简称 Java 容器
  - 说明：此时的存储主要指的是内存的存储，不涉及到持久化的存储
- 数组
  - 数组在存储多个数据方面的特点
    - 一旦初始化以后，长度就确定了
    - 数组一旦定义好，其元素的类型也就确定了
      - 我们也就只能操作指定类型的数据了
      - 比如 `String[] arr`、`int[] arr`
  - 数组在存储多个数据方面的缺点
    - 一旦初始化以后，其长度就不可修改
    - 数组中提供的方法非常有限
      - 对于添加、删除、插入数据等操作，非常不便
      - 获取数组中实际元素的个数的需求，数组没有现成的属性或方法
    - 数组存储数据的特点：有序、可重复
      - 对于无序、不可重复的需求，不能满足

## 集合框架

- `Collection` 接口：单列集合，用来存储一个一个的对象
  - `List` 接口：存储有序的、可重复的数据（动态数组）
    - `ArrayList`
    - `LinkedList`
    - `Vector`
  - `Set` 接口：存储无序的、不可重复的数据（集合）
    - `HashSet`
    - `LinkedHashSet`
    - `TreeSet`
- `Map` 接口：双列集合，用来存储一对一对的数据（key - value）
  - `HashMap`
  - `LinkedHashMap`
  - `TreeMap`
  - `Hashtable`
  - `Properties`
 */
public class CollectionMapOverview {
    public static void main(String[] args) {

    }
}
