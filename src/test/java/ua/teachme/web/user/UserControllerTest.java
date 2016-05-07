package ua.teachme.web.user;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import ua.teachme.util.exception.EntityNotFoundException;
import ua.teachme.util.user.UserUtil;

import static org.junit.Assert.*;

//tests with JUnit
//todo change junit to spring test here, throw junit realization to MainTest
public class UserControllerTest {

    private static ConfigurableApplicationContext appCtx;
    private static UserController userController;


    @Test//(expected = EntityNotFoundException.class)
    public void testGetByEmail() throws Exception {
        userController.getByEmail("anonymous@gmail.com");
        //userController.getByEmail("");
    }

    @Test
    public void testGetAll() throws Exception {
        assertEquals(3, userController.getAll().size());
    }

    @Test
    public void testSave() throws Exception {
        assertEquals(3, userController.getAll().size());
        assertEquals(UserUtil.newUser, userController.save(UserUtil.newUser));
        assertEquals(4, userController.getAll().size());
    }

    @Test(expected = EntityNotFoundException.class)
    public void testGet() throws Exception {
        userController.get(1000001);
        userController.get(-1000001);
    }

    @Test
    public void testDelete() throws Exception {
        assertEquals(3, userController.getAll().size());
        userController.delete(1000001);
        assertEquals(2, userController.getAll().size());
    }
}