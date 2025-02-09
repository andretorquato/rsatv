package com.produtos.repository;

import java.util.List;

public interface CrudRepository<T extends Identifiable> {
    void save(T entity);
    T findById(int id);
    void update(T entity);
    void delete(int id);
    List<T> findAll();
}
