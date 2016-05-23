package ua.teachme.repository.jdbc;

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
import ua.teachme.profiles.PopulateDB;
import ua.teachme.profiles.WorkBy;
import ua.teachme.repository.UserRepository;
import ua.teachme.util.user.UserUtil;

import static org.junit.Assert.*;

@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/db-connect.xml", "classpath:spring/db-behaviour.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles({ConnectTo.HSQLDB, WorkBy.JDBC})
@Sql(scripts = PopulateDB.HSQLDB) //execute before every test in this class
public class JdbcUserRepositoryImplTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testUserRepository(){
        assertNotNull(userRepository);
        assertEquals(JdbcUserRepositoryImpl.class, userRepository.getClass());
    }

    @Test
    public void testGetByEmail() throws Exception {
        assertEquals(UserUtil.admin, userRepository.getByEmail("admin@gmail.com"));
    }

    @Test
    public void testGetAll() throws Exception {
        assertEquals(3, userRepository.getAll().size());
    }

    @Test
    public void testSave() throws Exception {
        assertEquals(3, userRepository.getAll().size());
        assertEquals(UserUtil.equalUser, userRepository.save(UserUtil.newUser));
        assertEquals(4, userRepository.getAll().size());
    }

    @Test
    public void testGet() throws Exception {
        assertEquals(UserUtil.anonymous, userRepository.get(1000001));
    }

    @Test
    public void testDelete() throws Exception {
        assertEquals(3, userRepository.getAll().size());
        userRepository.delete(1000001);
        assertEquals(2, userRepository.getAll().size());
    }
}