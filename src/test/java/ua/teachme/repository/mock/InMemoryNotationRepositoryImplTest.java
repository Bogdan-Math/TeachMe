package ua.teachme.repository.mock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.teachme.model.Notation;
import ua.teachme.repository.NotationRepository;
import ua.teachme.util.notation.NotationUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.*;

@ContextConfiguration("classpath:spring/mock.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class InMemoryNotationRepositoryImplTest {

    @Autowired
    private NotationRepository notationRepository;

    @Before
    public void before(){
        notationRepository.getAll().forEach(notation -> notationRepository.delete(notation.getId()));
        NotationUtil.notations.forEach(notation -> notationRepository.save(notation));
    }

    @Test
    public void testGetAll() throws Exception {
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