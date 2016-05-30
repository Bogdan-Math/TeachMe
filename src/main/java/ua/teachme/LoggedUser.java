package ua.teachme;

import ua.teachme.model.User;

public class LoggedUser extends org.springframework.security.core.userdetails.User {

    public LoggedUser(User user) {
        super(user.getEmail(), user.getPassword(), user.getRoles());
    }
}