package ua.teachme.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import ua.teachme.dto.UserTO;
import ua.teachme.model.User;
import ua.teachme.service.UserService;
import ua.teachme.util.user.UserUtil;

public abstract class AbstractRegistrationController {

    @Autowired
    private UserService userService;

    public User save(UserTO userTO){
        return userService.save((UserUtil.saveUser(userTO)));
    }
}
