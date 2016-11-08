package org;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by liyaogang on 2016/10/31.
 */
public class LRUCache {

    LinkedHashMap cache;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap((int) Math.ceil(capacity / 0.75f) + 1, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            cache.get(key);
        }
        return -1;
    }

    public void set(int key, int value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.set(2, 1);
        lruCache.get(2);
    }
}
