package ua.teachme.repository;

import java.util.List;

public interface Repository<T> {
    List<T> getAll();
    T save(T entity);
    T get(int id);
    void delete(int id);
}