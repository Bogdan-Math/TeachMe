package ua.teachme;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static ConfigurableApplicationContext createAndGetSpringContext(){
        return new ClassPathXmlApplicationContext
                (
                        "spring/spring-app.xml",
                        "spring/db-connect.xml"
                );
    }
}