package ua.teachme.repository.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.teachme.profiles.WorkBy;
import ua.teachme.repository.NotationRepository;
import ua.teachme.util.notation.NotationUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@ContextConfiguration("classpath:spring/repository-implementations.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(WorkBy.MOCK)
public class InMemoryNotationRepositoryImplTest {

    @Autowired
    private NotationRepository notationRepository;

    @Before //execute BEFORE every test in this class
    public void setUp(){
        NotationUtil.notations.forEach(notation -> notationRepository.save(notation));
    }

    @After //execute AFTER every test in this class
    public void tearDown(){
        notationRepository.getAll().forEach(notation -> notationRepository.delete(notation.getId()));
    }

    @Test
    public void testNotationRepository(){
        assertNotNull(notationRepository);
    }

    @Test
    public void testGetAll() throws Exception {
        assertThat(notationRepository.getAll(), is(NotationUtil.notations));
        assertEquals(8, notationRepository.getAll().size());
    }

    @Test
    public void testSave() throws Exception {
        assertEquals(8, notationRepository.getAll().size());
        assertEquals(NotationUtil.notation, notationRepository.save(NotationUtil.notation));
        assertEquals(9, notationRepository.getAll().size());
    }

    @Test
    public void testGet() throws Exception {
        assertEquals(NotationUtil.notation, notationRepository.get(1));
    }

    @Test
    public void testDelete() throws Exception {
        assertEquals(8, notationRepository.getAll().size());
        notationRepository.delete(1);
        assertEquals(7, notationRepository.getAll().size());
    }

    @Test
    public void testGetBetween() throws Exception {
        assertEquals(4,
                    notationRepository.getBetween(
                            LocalDateTime.of(LocalDate.now(), LocalTime.MIN),
                            LocalDateTime.of(LocalDate.now(), LocalTime.MAX)
                    ).size()
        );
    }
}