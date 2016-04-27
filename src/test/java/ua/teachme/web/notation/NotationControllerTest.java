package ua.teachme.web.notation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.teachme.model.Notation;
import ua.teachme.util.PopulatorDB;
import ua.teachme.util.exception.EntityNotFoundException;
import ua.teachme.util.notation.NotationUtil;
import ua.teachme.util.time.TimeUtil;

import static org.junit.Assert.*;


//tests with Spring
@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/spring-db.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class NotationControllerTest {

    @Autowired
    private NotationController notationController;

    @Autowired
    private PopulatorDB populatorDB;

    @Before//execute before every test in this class
    public void before(){
        populatorDB.execute();
    }


    @Test
    public void testGetAll() throws Exception {
        assertEquals(3, notationController.getAll().size());
    }

    @Test
    public void testSave() throws Exception {
        assertEquals(3, notationController.getAll().size());
        notationController.save(NotationUtil.NOTATIONS.get(0));
        assertEquals(4, notationController.getAll().size());
    }

    @Test(expected = EntityNotFoundException.class)
    public void testGet() throws Exception {
        notationController.get(1000004);
        notationController.get(0);
    }

    @Test
    public void testDelete() throws Exception {
        assertEquals(3, notationController.getAll().size());
        notationController.delete(1000004);
        assertEquals(2, notationController.getAll().size());
    }

    @Test
    public void testGetBetween() throws Exception {
        Notation notation = notationController.get(1000004);
        assertEquals(
                1,
                notationController.getBetween(
                        notation.getDate(), notation.getTime(),
                        notation.getDate(), notation.getTime()
                ).size()
        );
    }
}