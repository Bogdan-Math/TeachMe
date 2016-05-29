package ua.teachme.repository;

import ua.teachme.model.Notation;

import java.time.LocalDateTime;
import java.util.List;

public interface NotationRepository extends Repository<Notation> {
    List<Notation> getBetween(LocalDateTime start, LocalDateTime end);
    List<Notation> getByUserId(int userId);
}
