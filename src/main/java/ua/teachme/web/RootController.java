package ua.teachme.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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