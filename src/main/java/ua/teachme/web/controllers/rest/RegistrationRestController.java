package ua.teachme.web.controllers.rest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.teachme.dto.UserTO;
import ua.teachme.web.controllers.AbstractRegistrationController;

@RestController
@RequestMapping(value = "/rest/registration")
public class RegistrationRestController extends AbstractRegistrationController {

    @RequestMapping(method = RequestMethod.POST)
    public void save(UserTO userTO){
        try {
            super.save(userTO);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("!!!");
        }
    }
}
