package ua.teachme;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

    public static GenericXmlApplicationContext createAndGetSpringContext(){
        GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext();
        appCtx.getEnvironment().setActiveProfiles(ConnectTo.HSQLDB, WorkBy.JPA);
        appCtx.load("spring/spring-app.xml", "spring/db-connect.xml", "spring/db-behaviour.xml");
        appCtx.refresh();
        return appCtx;
    }
}