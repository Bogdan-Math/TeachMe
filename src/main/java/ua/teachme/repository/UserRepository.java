package ua.teachme.repository;

import ua.teachme.model.User;

public interface UserRepository extends Repository<User>{
    User getByEmail(String email);
}
