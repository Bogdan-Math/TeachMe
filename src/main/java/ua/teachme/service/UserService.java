package ua.teachme.service;

import org.springframework.cache.annotation.CacheEvict;
import ua.teachme.model.User;
import ua.teachme.utility.exception.EntityNotFoundException;

public interface UserService extends Service<User> {
    User getByEmail(String email) throws EntityNotFoundException;

    @Override
    @CacheEvict(value = "users", allEntries = true)
    default void evictCache() {
    }
}
