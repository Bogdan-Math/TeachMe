package ua.teachme.web.notation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.teachme.service.NotationService;

@Controller
public class NotationController {

    private static final Logger LOG = LoggerFactory.getLogger(NotationController.class);
    
    @Autowired
    private NotationService notationService;

}
