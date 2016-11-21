package ua.teachme;

import org.springframework.context.support.GenericXmlApplicationContext;
import ua.teachme.profiles.db.ConnectTo;
import ua.teachme.profiles.db.WorkBy;

//todo: delete this class after ALPHA-production
public class Main {

    private static GenericXmlApplicationContext appCtx;

    private Main() {
        createSpringContext();
    }

    public static GenericXmlApplicationContext getSpringContext() {
        if (null == appCtx) {
            createSpringContext();
            return appCtx;
        }
        else {
            return appCtx;
        }
    }

    private static void createSpringContext() {
        appCtx = new GenericXmlApplicationContext();
        appCtx.getEnvironment().setActiveProfiles(ConnectTo.HSQLDB, WorkBy.JPA);
        appCtx.load("spring/spring-app.xml", "spring/db-connect.xml", "spring/db-behaviour.xml");
        appCtx.refresh();
    }
}