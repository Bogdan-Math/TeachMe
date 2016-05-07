package ua.teachme;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static ConfigurableApplicationContext createAndGetSpringContext(){
        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext
                (
                        "spring/spring-app.xml",
                        "spring/spring-db.xml"
                );
        return appCtx;
    }
}