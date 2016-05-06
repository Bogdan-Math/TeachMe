package ua.teachme.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.teachme.model.User;
import ua.teachme.repository.UserRepository;

import java.util.List;

@Repository
public class DataJpaUserRepositoryPseudoImpl implements UserRepository{

    @Autowired
    private ProxyUserRepository proxyUserRepository;

    @Override
    public User getByEmail(String email) {
        return proxyUserRepository.findByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return proxyUserRepository.findAll();
    }

    @Override
    public User save(User entity) {
        return proxyUserRepository.save(entity);
    }

    @Override
    public User get(int id) {
        return proxyUserRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        proxyUserRepository.deleteById(id);
    }
}
