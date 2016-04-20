package ua.teachme.repository.memory;

import ua.teachme.model.User;
import ua.teachme.repository.UserRepository;

import java.util.Collection;

//todo impl methods
public class InMemoryUserRepositoryImpl implements UserRepository {

    @Override
    public Collection<User> getAll() {
        return null;
    }

    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
