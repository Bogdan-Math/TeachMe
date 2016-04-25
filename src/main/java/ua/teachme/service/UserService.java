package ua.teachme.service;

import ua.teachme.model.User;
import ua.teachme.util.exception.EntityNotFoundException;

public interface UserService extends Service<User> {
    User getByEmail(String email)  throws EntityNotFoundException;
}
