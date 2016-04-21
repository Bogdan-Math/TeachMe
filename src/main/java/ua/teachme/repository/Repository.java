package ua.teachme.repository;

import java.util.List;

public interface Repository<T> {
    List<T> getAll();
    T save(T entity); //create and update
    T get(int id); //read
    void delete(int id); //delete
}