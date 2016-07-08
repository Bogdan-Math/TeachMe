package ua.teachme.web.controllers.view;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.teachme.dto.UserTO;
import ua.teachme.web.controllers.AbstractRegistrationController;

@Controller
@RequestMapping( value = "/registration")
public class RegistrationController extends AbstractRegistrationController {

    @RequestMapping(method = RequestMethod.GET)
    public String getRegistrationForm(){
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String userRegistration(UserTO userTO, Model model){
        try {
            super.save(userTO);
            model.addAttribute("message", true);
            model.addAttribute("loginError", false);
            return "login";

        }
        catch (DataIntegrityViolationException e){
            model.addAttribute("email", userTO.getEmail());
            model.addAttribute("duplicateEmailError", true);
            return "registration";
        }
    }

}
