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
import ua.teachme.model.Notation;
import ua.teachme.profiles.ConnectTo;
import ua.teachme.profiles.Populate;
import ua.teachme.profiles.WorkBy;
import ua.teachme.repository.NotationRepository;
import ua.teachme.util.notation.NotationUtil;

import static org.junit.Assert.*;

@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/db-connect.xml", "classpath:spring/db-behaviour.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles({ConnectTo.POSTGRESQL, WorkBy.JDBC})
@Sql(scripts = Populate.POSTGRESQL) //execute before every test in this class
//todo: to use HSQLDB in jdbc test need to add strategy (Timestamp to localDateTime and reverse)
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
    public void testGetAll() throws Exception {
        assertEquals(6, notationRepository.getAll().size());
    }

    @Test
    public void testSave() throws Exception {
        assertEquals(6, notationRepository.getAll().size());
        assertEquals(NotationUtil.newNotation, notationRepository.save(NotationUtil.newNotation));
        assertEquals(7, notationRepository.getAll().size());
    }

    @Test
    public void testGet() throws Exception {
        assertEquals(NotationUtil.notations.get(0), notationRepository.get(1000007));
    }

    @Test
    public void testDelete() throws Exception {
        assertEquals(6, notationRepository.getAll().size());
        notationRepository.delete(1000007);
        assertEquals(5, notationRepository.getAll().size());
    }

    @Test
    public void testGetBetween() throws Exception {
        Notation notation = notationRepository.get(1000007);
        assertEquals(
                2,
                notationRepository.getBetween(
                        notation.getCreatedDateAndTime(),
                        notation.getCreatedDateAndTime()
                ).size()
        );
    }
}