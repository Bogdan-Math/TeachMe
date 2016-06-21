package ua.teachme.web.controllers.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.teachme.dto.UserTO;
import ua.teachme.model.User;
import ua.teachme.web.controllers.AbstractRegistrationController;

@RestController
@RequestMapping(value = "/rest/registration")
public class RegistrationRestController extends AbstractRegistrationController {

    @RequestMapping(method = RequestMethod.POST)
    public User save(UserTO userTO){
        return super.save(userTO);
    }
}
