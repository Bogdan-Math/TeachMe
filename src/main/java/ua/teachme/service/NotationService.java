package ua.teachme.service;

import org.springframework.cache.annotation.CacheEvict;
import ua.teachme.model.Notation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface NotationService extends Service<Notation> {

    List<Notation> getBetween(LocalDate start, LocalDate end);
    List<Notation> getBetween(LocalDateTime start, LocalDateTime end);

    @Override
    @CacheEvict(value = "notations", allEntries = true)
    default void evictCache() {
    }

    List<Notation> getByUserId(int userId);
}