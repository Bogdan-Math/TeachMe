package ua.teachme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ua.teachme.model.Notation;
import ua.teachme.repository.NotationRepository;
import ua.teachme.util.exception.ExceptionUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class NotationServiceImpl implements NotationService {

    @Autowired
    private NotationRepository notationRepository;

    @Override
    @Cacheable(value = "notations")
    public List<Notation> getAll() {
        return notationRepository.getAll();
    }

    @Override
    @CacheEvict(value = "notations", allEntries = true)
    public Notation save(Notation entity) {
        return notationRepository.save(entity);
    }

    @Override
    public Notation get(int id) {
        return ExceptionUtil.check(notationRepository.get(id), id);
    }

    @Override
    @CacheEvict(value = "notations", allEntries = true)
    public void delete(int id) {
        notationRepository.delete(id);
    }

    @Override
    @Cacheable(value = "notations")
    public List<Notation> getBetween(LocalDate start, LocalDate end) {
        return getBetween(
                LocalDateTime.of(start, LocalTime.MIN),
                LocalDateTime.of(end, LocalTime.MAX)
        );
    }

    @Override
    @Cacheable(value = "notations")
    public List<Notation> getBetween(LocalDateTime start, LocalDateTime end) {
        return notationRepository.getBetween(start, end);
    }
}
