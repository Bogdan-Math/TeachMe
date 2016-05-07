package ua.teachme;

import org.springframework.context.support.GenericXmlApplicationContext;
import ua.teachme.profiles.ConnectTo;
import ua.teachme.profiles.WorkBy;

public class Main {

    public static GenericXmlApplicationContext createAndGetSpringContext(){
        GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext();
        appCtx.getEnvironment().setActiveProfiles(ConnectTo.HSQLDB, WorkBy.JPA);
        appCtx.load("spring/spring-app.xml", "spring/db-connect.xml", "spring/db-behaviour.xml");
        appCtx.refresh();
        return appCtx;
    }
}