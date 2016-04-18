package ua.teachme.repository;

import ua.teachme.model.Notation;
import ua.teachme.util.NotationUtil;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class NotationRepositoryInMemoryImpl implements NotationRepository {

    private Map<Integer, Notation> notationsRepository =  new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    public NotationRepositoryInMemoryImpl() {
        NotationUtil.NOTATIONS.forEach(this::save);
    }

    @Override
    public void save(Notation notation) {
        if (notation.isNew()){
            notation.setId(counter.incrementAndGet());
        }
        notationsRepository.put(notation.getId(), notation);
    }

    @Override
    public Notation get(int id) {
        return notationsRepository.get(id);
    }

    @Override
    public void delete(int id) {
        notationsRepository.remove(id);
    }

    @Override
    public Collection<Notation> getAll() {
        return notationsRepository.values();
    }
}
