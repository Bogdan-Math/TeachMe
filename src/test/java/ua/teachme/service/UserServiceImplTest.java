package ua.teachme.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.teachme.profiles.ConnectTo;
import ua.teachme.profiles.Populate;
import ua.teachme.profiles.WorkBy;

import static org.junit.Assert.*;

//tests with Spring
@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/db-connect.xml", "classpath:spring/db-behaviour.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles({ConnectTo.POSTGRESQL, WorkBy.JPA})
@Sql(scripts = Populate.POSTGRESQL) //execute before every test in this class
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

    }

    @Test
    public void testGetAll() throws Exception {

    }

    @Test
    public void testSave() throws Exception {

    }

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }
}