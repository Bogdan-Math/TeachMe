package ua.teachme.web;

import org.slf4j.Logger;
import org.slf4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
@RequestMapping( value = "/", method = RequestMethod.GET)
public class RootController {

    private static final Logger LOG = getLogger(RootController.class);

    @RequestMapping(value = "login")
    public String login(
            ModelMap model,
            @RequestParam(value = "error", required = false) boolean error
    ) {
        model.put("loginError", error);
        MDC.put("logger_id", "root");
        LOG.debug("GET: /login");
        return "login";
    }

    @RequestMapping(value = "logout")
    public String logout(){
        MDC.put("logger_id", "root");
        LOG.debug("GET: /logout");
        return "login";
    }

    @RequestMapping()
    public String root(){
        MDC.put("logger_id", "root");
        LOG.debug("GET: /");
        return "index";
    }

    @RequestMapping(value = "index")
    public String index(){
        MDC.put("logger_id", "root");
        LOG.debug("GET: /index");
        return "index";
    }
}