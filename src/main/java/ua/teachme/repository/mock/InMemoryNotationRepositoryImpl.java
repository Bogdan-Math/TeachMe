package ua.teachme.repository.mock;

import org.springframework.stereotype.Repository;
import ua.teachme.model.Notation;
import ua.teachme.repository.NotationRepository;
import ua.teachme.util.notation.NotationUtil;
import ua.teachme.util.time.TimeUtil;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class InMemoryNotationRepositoryImpl implements NotationRepository {

    private AtomicInteger counter = new AtomicInteger(0);
    private Map<Integer, Notation> notationsRepository =  new ConcurrentHashMap<>();
    private Comparator<Notation> notationComparator = Comparator.comparing(Notation::getDateTime);

    public InMemoryNotationRepositoryImpl() {
        NotationUtil.NOTATIONS.forEach(this::save);
    }

    @Override
    public List<Notation> getAll() {
        return notationsRepository.values().stream().sorted(notationComparator).collect(Collectors.toList());
    }

    @Override
    public Notation save(Notation notation) {
        if (notation.isNew()){
            notation.setId(counter.incrementAndGet());
        }
        notationsRepository.put(notation.getId(), notation);
        return notation;
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
    public List<Notation> getBetween(LocalDateTime start, LocalDateTime end) {
        return getAll().stream().filter(notation -> TimeUtil.isBetween(notation.getDateTime(), start, end)).collect(Collectors.toList());
    }
}