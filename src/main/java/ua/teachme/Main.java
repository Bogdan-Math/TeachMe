package ua.teachme;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.teachme.dto.NotationExceed;
import ua.teachme.util.user.UserUtil;
import ua.teachme.web.notation.NotationController;
import ua.teachme.web.user.UserController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class Main {

/*
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
*/

    public static void main(String[] args) {

/*
        MDC.put("logger_id", "filename_to_logging");
        LOG.debug("logging");
*/

        System.out.println("Hello TeachMe Enterprise!");

    }
}
