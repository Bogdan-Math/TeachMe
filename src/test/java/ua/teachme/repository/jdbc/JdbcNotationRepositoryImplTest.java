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
import ua.teachme.profiles.Populate;
import ua.teachme.profiles.WorkBy;
import ua.teachme.repository.NotationRepository;

import static org.junit.Assert.*;

@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/db-connect.xml", "classpath:spring/db-behaviour.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles({ConnectTo.HSQLDB, WorkBy.JDBC})
@Sql(scripts = Populate.HSQLDB) //execute before every test in this class
//todo: add more requirements and checks to tests
public class JdbcNotationRepositoryImplTest {

    @Autowired
    private NotationRepository notationRepository;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testNotationRepository(){
        assertNotNull(notationRepository);
        assertEquals(JdbcNotationRepositoryImpl.class, notationRepository.getClass());
    }

    @Test
    public void testGetBetween() throws Exception {

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