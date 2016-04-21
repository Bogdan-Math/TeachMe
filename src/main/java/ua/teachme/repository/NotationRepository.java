package ua.teachme.repository;

import ua.teachme.model.Notation;

import java.time.LocalDateTime;
import java.util.List;

public interface NotationRepository extends Repository<Notation> {

    List<Notation> getBetween(LocalDateTime start, LocalDateTime end);
/*
    Collection<Notation> getAll(User user);
    Notation save(User user, Notation notation);
    Notation get(User user, int id);
    void delete(User user, int id);
    Collection<Notation> getByUser(User user);
*/
}
