package ua.teachme.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.teachme.dto.UserTO;
import ua.teachme.service.UserService;
import ua.teachme.util.user.UserUtil;

@Controller
@RequestMapping( value = "/", method = RequestMethod.POST)
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "registration")
    public String userRegistration(UserTO userTO){
        userService.save(UserUtil.saveUser(userTO));
        return "redirect:/";
    }

}
