package collectionmap;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
# `Map` 中常用的方法

## 总结

- 添加：`V put(K key, V value)`
- 删除：`V remove(Object key)`
- 修改：`V put(K key, V value)`
- 查询：`V get(Object key)`
- 长度：`int size()`
- 遍历
  - Set<K> keySet()`
  - `Collection<V> values()`
  - `Set<Map.Entry<K,V>> entrySet()`
 */
public class MapTest1 {
    /*
    ## 添加、删除、修改

    - `V put(K key, V value)`：将指定的 key - value 添加到（或修改）当前 Map 对象中
    - `void putAll(Map<? extends K, ? extends V> m)`：将 `m` 中的所有 key - value 对存放到当前 map 中
    - `V remove(Object key)`：移除指定 key 的 key - value 对，并返回 value
    - `void clear()`：清空当前 map 中的所有数据
     */
    @Test
    public void test1() {
        HashMap hashMap = new HashMap();
        // 添加
        hashMap.put("1", "a");
        hashMap.put("2", "b");
        // 修改
        hashMap.put("1", "c");
        System.out.println(hashMap);

        System.out.println();

        HashMap hashMap1 = new HashMap();
        hashMap1.put("3", "c");
        hashMap1.put("4", "d");
        hashMap1.put("1", "a");
        hashMap.putAll(hashMap1);
        System.out.println(hashMap);

        System.out.println();

        Object o = hashMap.remove("1");
        Object o1 = hashMap.remove("1");
        System.out.println(hashMap);
        System.out.println(o);
        System.out.println(o1);

        System.out.println();

        hashMap.clear();
        System.out.println(hashMap);
    }

    /*
    ## 元素查询的操作

    - `V get(Object key)`：获取指定 key 对应的 value
    - `boolean containsKey(Object key)`：是否包含指定的 key
    - `boolean containsValue(Object value)`：是否包含指定的 value
    - `int size()`：返回 map 中 key - value 的个数
    - `boolean isEmpty()`：判断当前 map 是否为空
    - `boolean equals(Object o)`：判断当前 map 和参数对象 o 是否相等
     */
    @Test
    public void test2() {
        HashMap hashMap = new HashMap();
        hashMap.put("1", "a");
        hashMap.put("2", "b");
        hashMap.put("3", "c");

        Object o = hashMap.get("2");
        Object o1 = hashMap.get("0");

        System.out.println(o);
        System.out.println(o1);

        System.out.println();

        boolean b = hashMap.containsKey("1");
        boolean b1 = hashMap.containsKey("4");
        System.out.println(b);
        System.out.println(b1);

        System.out.println();

        boolean b2 = hashMap.containsValue("a");
        boolean b3 = hashMap.containsValue("d");
        System.out.println(b2);
        System.out.println(b3);

        System.out.println();

        System.out.println(hashMap.size());

        System.out.println();

        System.out.println(hashMap.isEmpty());
        hashMap.clear();
        System.out.println(hashMap.isEmpty());
    }

    /*
    ## 元视图操作的方法

    - `Set<K> keySet()`：返回所有 key 构成的 Set 集合
    - `Collection<V> values()`：返回所有 value 构成的 Collection 集合
    - `Set<Map.Entry<K,V>> entrySet()`：返回所有 key - value 构成的 Set 集合
     */
    @Test
    public void test3() {
        HashMap hashMap = new HashMap();
        hashMap.put("1", "a");
        hashMap.put("2", "b");
        hashMap.put("3", "c");

        Set keySet = hashMap.keySet();

        for (Object key : keySet) {
            System.out.println(key);
        }

        System.out.println();

        Collection values = hashMap.values();
        System.out.println(values.getClass());

        for (Object value : values) {
            System.out.println(value);
        }

        System.out.println();

        for (Object o : hashMap.entrySet()) {
            System.out.println(o);
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
