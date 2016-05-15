package ua.teachme.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.teachme.service.NotationService;
import ua.teachme.service.UserService;
import ua.teachme.util.notation.NotationUtil;

@Controller
public class RootController {

    @Autowired
    private UserService userService;

    @Autowired
    private NotationService notationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root(){
        return "index";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String users(Model model){
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @RequestMapping(value = "notations", method = RequestMethod.GET)
    public String notations(Model model){
        model.addAttribute("notations", NotationUtil.getFilteredWithExceed(notationService.getAll(), NotationUtil.hours));
        return "notations";
    }
}
