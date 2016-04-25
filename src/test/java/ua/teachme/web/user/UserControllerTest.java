package ua.teachme.web.user;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.teachme.Main;
import ua.teachme.model.User;
import ua.teachme.util.exception.EntityNotFoundException;
import ua.teachme.util.user.UserUtil;

import java.util.List;

import static org.junit.Assert.*;

//use JUnit tests
public class UserControllerTest {

    private static ConfigurableApplicationContext appCtx;
    private static UserController userController;

    @BeforeClass
    public static void beforeClass(){
        appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        userController = appCtx.getBean(UserController.class);
    }

    @Before
    public void before(){
        userController.getAll().forEach(user -> userController.delete(user.getId()));
        UserUtil.users.forEach(user -> userController.save(user));
    }

    @AfterClass
    public static void afterClass(){
        appCtx.close();
    }

    @Test(expected = EntityNotFoundException.class)
    public void testGetByEmail() throws Exception {
        assertEquals(userController.getByEmail("admin-email"), UserUtil.users.get(0));
        assertEquals(userController.getByEmail("common-user-email"), UserUtil.users.get(1));
        assertEquals(userController.getByEmail("anonymous-email"), UserUtil.users.get(2));
        userController.getByEmail("");
    }

    @Test
    public void testGetAll() throws Exception {
        assertEquals(3, userController.getAll().size());
    }

    @Test
    public void testSave() throws Exception {
        assertEquals(UserUtil.users.get(0), userController.save(UserUtil.users.get(0)));
    }

    @Test(expected = EntityNotFoundException.class)
    public void testGet() throws Exception {
        assertEquals(userController.get(1), UserUtil.users.get(0));
        assertEquals(userController.get(2), UserUtil.users.get(1));
        assertEquals(userController.get(3), UserUtil.users.get(2));
        userController.get(0);
    }

    @Test
    public void testDelete() throws Exception {
        userController.delete(1);
        assertEquals(2, userController.getAll().size());
    }
}