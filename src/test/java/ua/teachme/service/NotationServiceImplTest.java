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
import ua.teachme.model.Notation;
import ua.teachme.profiles.ConnectTo;
import ua.teachme.profiles.PopulateDB;
import ua.teachme.profiles.WorkBy;
import ua.teachme.utility.exception.EntityNotFoundException;
import ua.teachme.utility.notation.NotationUtil;

import java.util.List;

import static org.junit.Assert.*;

//tests with Spring
@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/db-connect.xml", "classpath:spring/db-behaviour.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles({ConnectTo.POSTGRESQL, WorkBy.JPA})
@Sql(scripts = PopulateDB.POSTGRESQL) //execute before every test in this class
//todo: add more requirements and checks to tests
public class NotationServiceImplTest {

    @Autowired
    private NotationService notationService;

    @Before
    public void setUp(){
        notationService.evictCache();
    }

    @After
    public void tearDown(){

    }

    @Test
    public void testNotationService(){
        assertNotNull(notationService);
    }

    @Test
    public void testGetAll() throws Exception {
        List<Notation> notations = notationService.getAll();
        assertNotNull(notations);
        assertEquals(6, notations.size());
        assertTrue(notations.containsAll(NotationUtil.notations) && NotationUtil.notations.containsAll(notations));
    }

    @Test
    public void testSave() throws Exception {
        assertEquals(6, notationService.getAll().size());
        assertEquals(NotationUtil.newNotation, notationService.save(NotationUtil.newNotation));
        assertEquals(7, notationService.getAll().size());
    }

    @Test(expected = EntityNotFoundException.class)
    public void testGet() throws Exception {
        assertEquals(NotationUtil.notations.get(0), notationService.get(1000007));
        notationService.get(-1);
    }

    @Test(expected = EntityNotFoundException.class)
    public void testDelete() throws Exception {
        assertEquals(6, notationService.getAll().size());
        notationService.delete(1000007);
        assertEquals(5, notationService.getAll().size());
        notationService.get(1000007);
    }

    @Test
    public void testGetBetween_1() throws Exception {
        Notation notation = notationService.get(1000007);
        assertEquals(
                2,
                notationService.getBetween(
                        notation.getDate(),
                        notation.getDate()
                ).size()
        );
    }

    @Test
    public void testGetBetween_2() throws Exception {
        Notation notation = notationService.get(1000007);
        assertEquals(
                2,
                notationService.getBetween(
                        notation.getCreatedDateAndTime(),
                        notation.getCreatedDateAndTime()
                ).size()
        );
    }

    @Test
    public void getByUserId() throws Exception {
        notationService.getByUserId(1000001).forEach(System.out::println);
    }
}