package ua.teachme.repository;

import java.util.Collection;

public interface Repository<T> {
    Collection<T> getAll();
    T save(T entity);
    T get(int id);
    void delete(int id);
}
