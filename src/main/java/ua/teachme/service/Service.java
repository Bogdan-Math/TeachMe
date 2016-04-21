package ua.teachme.service;

import ua.teachme.util.exception.EntityNotFoundException;

import java.util.List;

public interface Service<T> {
    List<T> getAll();
    T save(T entity);
    T get(int id) throws EntityNotFoundException;
    void delete(int id) throws EntityNotFoundException;
}
