package ua.teachme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.teachme.model.Notation;
import ua.teachme.repository.NotationRepository;
import ua.teachme.util.exception.ExceptionUtil;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotationServiceImpl implements NotationService {

    @Autowired
    private NotationRepository notationRepository;

    @Override
    public List<Notation> getAll() {
        return notationRepository.getAll();
    }

    @Override
    public Notation save(Notation entity) {
        return notationRepository.save(entity);
    }

    @Override
    public Notation get(int id) {
        return ExceptionUtil.check(notationRepository.get(id), id);
    }

    @Override
    public void delete(int id) {
        notationRepository.delete(id);
    }

    @Override
    public List<Notation> getBetween(LocalDateTime start, LocalDateTime end) {
        return notationRepository.getBetween(start, end);
    }
}
