package ua.teachme.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.teachme.model.User;
import ua.teachme.profiles.ConnectTo;
import ua.teachme.profiles.PopulateDB;
import ua.teachme.profiles.WorkBy;
import ua.teachme.utility.exception.EntityNotFoundException;
import ua.teachme.utility.password.PasswordUtil;
import ua.teachme.utility.user.UserUtil;

import java.util.List;

import static org.junit.Assert.*;

//tests with Spring
@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/db-connect.xml", "classpath:spring/db-behaviour.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles({ConnectTo.POSTGRESQL, WorkBy.JPA})
@Sql(scripts = PopulateDB.POSTGRESQL) //execute before every test in this class
//todo: add more requirements and checks to tests
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Before
    public void setUp(){
        userService.evictCache();
    }

    @After
    public void tearDown(){

    }

    @Test
    public void testUserService(){
        assertNotNull(userService);
    }

    @Test
    public void testGetByEmail() throws Exception {
        User userByEmail = userService.getByEmail("admin@gmail.com");
        assertNotNull(userByEmail);
        assertEquals(UserUtil.admin, userByEmail);
    }

    @Test
    public void testGetAll() throws Exception {
        List<User> users = userService.getAll();
        assertNotNull(users);
        assertEquals(3, users.size());
        assertTrue(users.containsAll(UserUtil.users) && UserUtil.users.containsAll(users));
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void testSave() throws Exception {
        assertEquals(3, userService.getAll().size());
        assertEquals(UserUtil.newUser, userService.save(UserUtil.newUser));
        assertEquals(4, userService.getAll().size());
        assertEquals(UserUtil.newUser, userService.getByEmail("new-user@gmail.com"));
        userService.save(UserUtil.equalUser);
    }

    @Test(expected = EntityNotFoundException.class)
    public void testGet() throws Exception {
        assertEquals(UserUtil.anonymous, userService.get(1000001));
        assertEquals(UserUtil.user, userService.get(1000002));
        assertEquals(UserUtil.admin, userService.get(1000003));
        userService.get(1000000);
    }

    @Test
    public void testDelete() throws Exception {
        assertEquals(3, userService.getAll().size());
        userService.delete(1000001);
        assertEquals(2, userService.getAll().size());
    }

    @Test
    @Ignore
    public void rePopulateDB(){
        List<User> users = userService.getAll();
        users.forEach(user -> user.setPassword(PasswordUtil.encode(user.getPassword())));
        users.forEach(user -> userService.save(user));
    }
}