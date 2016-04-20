package ua.teachme.service;

import java.util.Collection;

public interface Service<T> {
    Collection<T> getAll();
    T save(T entity);
    T get(int id);
    void delete(int id);
}
