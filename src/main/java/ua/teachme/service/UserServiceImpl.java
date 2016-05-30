package ua.teachme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.teachme.LoggedUser;
import ua.teachme.model.User;
import ua.teachme.repository.UserRepository;
import ua.teachme.util.exception.EntityNotFoundException;
import ua.teachme.util.exception.ExceptionUtil;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getByEmail(String email) throws EntityNotFoundException {
        return  ExceptionUtil.check(userRepository.getByEmail(email), email);
    }

    @Override
    @Cacheable(value = "users")
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    @CacheEvict(value = "users", allEntries = true)
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public User get(int id) throws EntityNotFoundException {
        return ExceptionUtil.check(userRepository.get(id), id);
    }

    @Override
    @CacheEvict(value = "users", allEntries = true)
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    public LoggedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getByEmail(email);
        if (null == user) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new LoggedUser(user);
    }
}