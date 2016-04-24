package ua.teachme;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    /*
        private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    */
    private static ConfigurableApplicationContext springContext;

    public static void main(String[] args) {

/*
        MDC.put("logger_id", "filename_to_logging");
        LOG.debug("logging");
*/
    }

    public static void createSpringContext(){
        springContext = new ClassPathXmlApplicationContext("spring/spring-app.xml");
    }

    public static ConfigurableApplicationContext getSpringContext(){
        return springContext;
    }

    public static void closeSpringContext(){
        springContext.close();
        springContext = null;
    }
}
