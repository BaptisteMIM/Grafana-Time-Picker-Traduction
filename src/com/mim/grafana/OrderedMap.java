package com.mim.grafana;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrderedMap<K,V> extends HashMap<K,V>{

    private List<K> keys;

    public OrderedMap() {
        super();
        this.keys = new ArrayList<>();
    }

    @Override
    public V put(K key, V value) {
        keys.add(key);
        return super.put(key, value);
    }

    @Override
    public V remove(Object key) {
        keys.remove(key);
        return super.remove(key);
    }

    @Override
    public void putAll(Map m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putAll'");
    }

    @Override
    public void clear() {
        keys.clear();
        super.clear();
    }

    public List<K> keyList(){
        return keys;
    }
    
}
