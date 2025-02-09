package com.produtos.repository;

import java.io.*;
import java.util.*;
import com.produtos.entity.Identifiable;

public class InFileRepository<T extends Identifiable & Serializable> implements CrudRepository<T> {
    private Map<Integer, T> storage = new HashMap<>();
    private int nextId = 1;
    private File file;
    
    public InFileRepository(String filename) {
        this.file = new File(filename);
        loadFromFile();
    }
    
    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        if (!file.exists()) {
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            storage = (Map<Integer, T>) ois.readObject();
            nextId = storage.keySet().stream().max(Integer::compare).orElse(0) + 1;
        } catch (Exception e) {
            System.out.println("Erro ao carregar dados do arquivo: " + e.getMessage());
        }
    }
    
    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(storage);
        } catch (Exception e) {
            System.out.println("Erro ao salvar dados no arquivo: " + e.getMessage());
        }
    }
    
    @Override
    public void save(T entity) {
        entity.setId(nextId++);
        storage.put(entity.getId(), entity);
        saveToFile();
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
            saveToFile();
        } else {
            System.out.println("Entidade com id " + id + " não encontrada.");
        }
    }
    
    @Override
    public void delete(int id) {
        storage.remove(id);
        saveToFile();
    }
    
    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }
}
