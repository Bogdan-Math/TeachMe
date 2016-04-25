package ua.teachme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.teachme.model.User;
import ua.teachme.repository.UserRepository;
import ua.teachme.util.exception.EntityNotFoundException;
import ua.teachme.util.exception.ExceptionUtil;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getByEmail(String email) throws EntityNotFoundException {
        return  ExceptionUtil.check(userRepository.getByEmail(email), email);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public User get(int id) throws EntityNotFoundException {
        return ExceptionUtil.check(userRepository.get(id), id);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }
}
