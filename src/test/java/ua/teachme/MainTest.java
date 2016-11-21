package ua.teachme;

import org.junit.*;
import org.springframework.context.support.GenericXmlApplicationContext;
import ua.teachme.profiles.db.ConnectTo;
import ua.teachme.profiles.db.WorkBy;

import static org.junit.Assert.*;

//tests with JUnit
public class MainTest {

    private static GenericXmlApplicationContext appCtx;

    @BeforeClass
    public static void beforeClass() {
        appCtx = new GenericXmlApplicationContext();
        appCtx.getEnvironment().setActiveProfiles(ConnectTo.HSQLDB, WorkBy.DATAJPA);
        appCtx.load("spring/spring-app.xml", "spring/db-connect.xml", "spring/db-behaviour.xml");
        appCtx.refresh();
    }

    @Before//execute BEFORE every test in this class
    public void setUp(){}

    @After//execute AFTER every test in this class
    public void tearDown(){}

    @AfterClass
    public static void afterClass(){
        appCtx.close();
    }

    @Test
    public void testCreateAndGetSpringContext() throws Exception {

        assertNotNull(Main.getSpringContext());
        assertEquals(Main.getSpringContext(), Main.getSpringContext());

//todo: delete this comments after ALPHA-production
/*
        //UserController
        assertEquals
                (
                        Main.getSpringContext().getBean(UserController.class).getClass(),
                        appCtx.getBean(UserController.class).getClass()
                );

        //NotationController
        assertEquals
                (
                        Main.getSpringContext().getBean(NotationController.class).getClass(),
                        appCtx.getBean(NotationController.class).getClass()
                );

        //UserService
        assertEquals
                (
                        Main.getSpringContext().getBean(UserService.class).getClass(),
                        appCtx.getBean(UserService.class).getClass()
                );

        //NotationService
        assertEquals
                (
                        Main.getSpringContext().getBean(NotationService.class).getClass(),
                        appCtx.getBean(NotationService.class).getClass()
                );

        //UserRepository
        assertEquals
                (
                        Main.getSpringContext().getBean(UserRepository.class).getClass(),
                        appCtx.getBean(UserRepository.class).getClass()
                );

        //NotationRepository
        assertEquals
                (
                        Main.getSpringContext().getBean(NotationRepository.class).getClass(),
                        appCtx.getBean(NotationRepository.class).getClass()
                );
*/
    }
}