package ua.teachme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Service;
import ua.teachme.model.Notation;
import ua.teachme.repository.NotationRepository;

import java.util.Collection;

@Service
public class NotationServiceImpl implements NotationService {

    @Autowired
    private NotationRepository notationRepository;

/*
    public void setNotationRepository(NotationRepository notationRepository) {
        this.notationRepository = notationRepository;
    }
*/

    @Override
    public Collection<Notation> getAll() {
        return null;
    }

    @Override
    public Notation save(Notation entity) {
        return notationRepository.save(entity);
    }

    @Override
    public Notation get(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
