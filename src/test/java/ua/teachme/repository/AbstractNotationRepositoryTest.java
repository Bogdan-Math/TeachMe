package ua.teachme.repository;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ua.teachme.model.Notation;
import ua.teachme.utility.notation.NotationUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public abstract class AbstractNotationRepositoryTest extends AbstractRepositoryTest {

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
    }

    @Test
    public void testGetAll() throws Exception {
        assertEquals(7, notationRepository.getAll().size());
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
