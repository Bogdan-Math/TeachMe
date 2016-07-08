package ua.teachme.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import ua.teachme.dto.UserTO;
import ua.teachme.service.UserService;
import ua.teachme.utility.user.UserUtil;

public abstract class AbstractRegistrationController {

    @Autowired
    private UserService userService;

    public void save(UserTO userTO){
        userService.save((UserUtil.saveUser(userTO)));
    }
}
