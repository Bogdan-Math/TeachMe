package ua.teachme.web.notation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ua.teachme.profiles.ConnectTo;
import ua.teachme.profiles.WorkBy;
import ua.teachme.model.Notation;
import ua.teachme.util.notation.NotationUtil;

import static org.junit.Assert.*;

//tests with Spring
@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/db-connect.xml", "classpath:spring/db-behaviour.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles({ConnectTo.POSTGRESQL, WorkBy.JPA})
@Sql(scripts = "classpath:db/postgres/populatePostgreSQL.sql") //execute before every test in this class
//todo: add more requirements and checks to tests
public class NotationControllerTest {

    @Autowired
    private NotationController notationController;

    @Test
    public void testNotationController(){
        assertNotNull(notationController);
    }

    @Test
    public void testGetAll() throws Exception {
        assertEquals(6, notationController.getAll().size());
    }

    @Test
    public void testSave() throws Exception {
        assertEquals(6, notationController.getAll().size());
        assertEquals(NotationUtil.newNotation, notationController.save(NotationUtil.newNotation));
        assertEquals(7, notationController.getAll().size());
    }

    @Test//(expected = EntityNotFoundException.class)
    public void testGet() throws Exception {
        notationController.get(1000007);
        //notationController.get(-10);
    }

    @Test
    public void testDelete() throws Exception {
        assertEquals(6, notationController.getAll().size());
        notationController.delete(1000007);
        assertEquals(5, notationController.getAll().size());
    }

    @Test
    @Transactional
    public void testGetBetween() throws Exception {
        Notation notation = notationController.get(1000007);
        assertEquals(
                2,
                notationController.getBetween(
                        notation.getDate(), notation.getTime(),
                        notation.getDate(), notation.getTime()
                ).size()
        );
    }
}