package ua.teachme.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import ua.teachme.model.User;
import ua.teachme.service.UserService;

public abstract class AbstractRegistrationController {

    @Autowired
    private UserService userService;

    public User save(User user){
        return userService.save(user);
    }
}
