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
@RequestMapping(method = RequestMethod.GET)
public class RootController {

    @RequestMapping(value = "/")
    public String root(){
        return "index";
    }

    @RequestMapping(value = "index")
    public String index(){
        return "index";
    }
}