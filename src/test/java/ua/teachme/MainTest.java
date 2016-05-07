package ua.teachme;

import org.junit.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.teachme.repository.NotationRepository;
import ua.teachme.repository.UserRepository;
import ua.teachme.service.NotationService;
import ua.teachme.service.UserService;
import ua.teachme.web.notation.NotationController;
import ua.teachme.web.user.UserController;

import static org.junit.Assert.*;

//tests with JUnit
public class MainTest {

    private static ConfigurableApplicationContext appCtx;

    @BeforeClass
    public static void beforeClass(){
        appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/connect-with-db.xml");
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

        //UserController
        assertEquals
                (
                        Main.createAndGetSpringContext().getBean(UserController.class).getClass(),
                        appCtx.getBean(UserController.class).getClass()
                );

        //NotationController
        assertEquals
                (
                        Main.createAndGetSpringContext().getBean(NotationController.class).getClass(),
                        appCtx.getBean(NotationController.class).getClass()
                );

        //UserService
        assertEquals
                (
                        Main.createAndGetSpringContext().getBean(UserService.class).getClass(),
                        appCtx.getBean(UserService.class).getClass()
                );

        //NotationService
        assertEquals
                (
                        Main.createAndGetSpringContext().getBean(NotationService.class).getClass(),
                        appCtx.getBean(NotationService.class).getClass()
                );

        //UserRepository
        assertEquals
                (
                        Main.createAndGetSpringContext().getBean(UserRepository.class).getClass(),
                        appCtx.getBean(UserRepository.class).getClass()
                );

        //NotationRepository
        assertEquals
                (
                        Main.createAndGetSpringContext().getBean(NotationRepository.class).getClass(),
                        appCtx.getBean(NotationRepository.class).getClass()
                );
    }
}