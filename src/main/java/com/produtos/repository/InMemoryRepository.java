package com.produtos.repository;

import java.util.*;
import com.produtos.entity.Identifiable;

public class InMemoryRepository<T extends Identifiable> implements CrudRepository<T> {
    private Map<Integer, T> storage = new HashMap<>();
    private int nextId = 1;
    
    @Override
    public void save(T entity) {
        entity.setId(nextId++);
        storage.put(entity.getId(), entity);
    }
    
    @Override
    public T findById(int id) {
        return storage.get(id);
    }
    
    @Override
    public void update(T entity) {
        int id = entity.getId();
        if (storage.containsKey(id)) {
            storage.put(id, entity);
        } else {
            System.out.println("Entidade com id " + id + " não encontrada.");
        }
    }
    
    @Override
    public void delete(int id) {
        storage.remove(id);
    }
    
    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }
}
