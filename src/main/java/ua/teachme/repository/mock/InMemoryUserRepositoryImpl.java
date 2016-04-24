package ua.teachme.repository.mock;

import org.springframework.stereotype.Repository;
import ua.teachme.model.User;
import ua.teachme.repository.UserRepository;
import ua.teachme.util.user.UserUtil;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class InMemoryUserRepositoryImpl implements UserRepository {

    private AtomicInteger counter = new AtomicInteger(0);
    private Map<Integer, User> userRepository = new ConcurrentHashMap<>();
    private Comparator<User> userComparator = Comparator.comparing(User::getName);

    public InMemoryUserRepositoryImpl() {
        UserUtil.users.stream().forEach(this::save);
    }

    @Override
    public List<User> getAll() {
        return userRepository.values().stream().sorted(userComparator).collect(Collectors.toList());
    }

    @Override
    public User save(User entity) {
        if (entity.isNew()){
            entity.setId(counter.incrementAndGet());
        }
        userRepository.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public User get(int id) {
        return userRepository.get(id);
    }

    @Override
    public void delete(int id) {
        userRepository.remove(id);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.values().stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
    }

    @PostConstruct
    public void postConstruct() {
    }

    @PreDestroy
    public void preDestroy() {
    }
}