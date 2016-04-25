package ua.teachme.web.notation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.teachme.util.exception.EntityNotFoundException;
import ua.teachme.util.notation.NotationUtil;
import ua.teachme.util.time.TimeUtil;

import static org.junit.Assert.*;

//use spring tests
@ContextConfiguration("classpath:spring/spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class NotationControllerTest {

    @Autowired
    private NotationController notationController;

    @Before
    public void before(){
        notationController.getAll().forEach(notation -> notationController.delete(notation.getId()));
        NotationUtil.NOTATIONS.forEach(notation -> notationController.save(notation));
    }

    @Test
    public void testGetAll() throws Exception {
        assertEquals(8, notationController.getAll().size());
    }

    @Test
    public void testSave() throws Exception {
        assertEquals(NotationUtil.NOTATIONS.get(0), notationController.save(NotationUtil.NOTATIONS.get(0)));
    }

    @Test(expected = EntityNotFoundException.class)
    public void testGet() throws Exception {
        assertEquals(notationController.get(1), NotationUtil.NOTATIONS.get(0));
        assertEquals(notationController.get(2), NotationUtil.NOTATIONS.get(1));
        notationController.get(0);
    }

    @Test
    public void testDelete() throws Exception {
        notationController.delete(1);
        assertEquals(7, notationController.getAll().size());
    }

    @Test
    public void testGetBetween() throws Exception {
        assertEquals(
                4,
                notationController.getBetween(TimeUtil.TODAY, TimeUtil.MIN_TIME, TimeUtil.TODAY, TimeUtil.MAX_TIME).size()
        );
    }
}