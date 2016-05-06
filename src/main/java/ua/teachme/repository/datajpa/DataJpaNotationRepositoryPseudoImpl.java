package ua.teachme.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.teachme.model.Notation;
import ua.teachme.repository.NotationRepository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
//todo add implementation by spring-data-jpa
public class DataJpaNotationRepositoryPseudoImpl implements NotationRepository {

    @Autowired
    private ProxyNotationRepository proxyNotationRepository;

    @Override
    public List<Notation> getBetween(LocalDateTime start, LocalDateTime end) {
        return proxyNotationRepository.findBetween(start, end);
    }

    @Override
    public List<Notation> getAll() {
        return proxyNotationRepository.findAll();
    }

    @Override
    public Notation save(Notation entity) {
        return proxyNotationRepository.save(entity);
    }

    @Override
    public Notation get(int id) {
        return proxyNotationRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        proxyNotationRepository.delete(id);
    }
}
