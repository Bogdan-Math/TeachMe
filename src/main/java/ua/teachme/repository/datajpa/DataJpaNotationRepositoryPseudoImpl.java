package ua.teachme.repository.datajpa;

import org.springframework.stereotype.Repository;
import ua.teachme.model.Notation;
import ua.teachme.repository.NotationRepository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
//todo add implementation by spring-data-jpa
public class DataJpaNotationRepositoryPseudoImpl implements NotationRepository {

    @Override
    public List<Notation> getBetween(LocalDateTime start, LocalDateTime end) {
        return null;
    }

    @Override
    public List<Notation> getAll() {
        return null;
    }

    @Override
    public Notation save(Notation entity) {
        return null;
    }

    @Override
    public Notation get(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
