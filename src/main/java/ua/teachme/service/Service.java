package ua.teachme.service;

import ua.teachme.utility.exception.EntityNotFoundException;

import java.util.List;

public interface Service<T> {
    List<T> getAll();
    T save(T entity);
    T get(int id) throws EntityNotFoundException;
    void delete(int id);

    //to clear cache
    void evictCache();
}