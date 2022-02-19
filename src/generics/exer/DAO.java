package generics.exer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO<T> {
    private final Map<String, T> map;

    public DAO() {
        map = new HashMap<>();
    }

    public DAO(Map<String, T> map) {
        this.map = map;
    }

    public void save(String id, T entity) throws RuntimeException {
        if (map.containsKey(id)) {
            throw new RuntimeException("id 已存在");
        } else {
            map.put(id, entity);
        }
    }

    public T get(String id) throws RuntimeException {
        if (map.containsKey(id)) {
            return map.get(id);
        } else {
            throw new RuntimeException("id 不存在");
        }
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    public void delete(String id) throws RuntimeException {
        if (map.containsKey(id)) {
            map.remove(id);
        } else {
            throw new RuntimeException("id 不存在");
        }
    }

    public List<T> list() {
        return new ArrayList<>(map.values());
    }
}
