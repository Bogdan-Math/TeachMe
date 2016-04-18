package ua.teachme.repository;

import ua.teachme.model.Notation;

import java.util.Collection;

public interface NotationRepository {
    void save(Notation notation);
    Notation get(int id);
    void delete(int id);
    Collection<Notation> getAll();
}
