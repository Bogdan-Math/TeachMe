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
import ua.teachme.repository.UserRepository;
import ua.teachme.util.user.UserUtil;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@ContextConfiguration("classpath:spring/repository-mock.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(WorkBy.MOCK)
public class InMemoryUserRepositoryImplTest {

    @Autowired
    private UserRepository userRepository;

    @Before //execute BEFORE every test in this class
    public void setUp(){
        UserUtil.users.forEach(user -> userRepository.save(user));
    }

    @After //execute AFTER every test in this class
    public void tearDown(){
        userRepository.getAll().forEach(user -> userRepository.delete(user.getId()));
    }

    @Test
    public void testUserRepository(){
        assertNotNull(userRepository);
    }

    @Test
    public void testGetAll() throws Exception {
        assertThat(userRepository.getAll(), is(UserUtil.users));
        assertEquals(3, userRepository.getAll().size());
    }

    @Test
    public void testSave() throws Exception {
        assertEquals(3, userRepository.getAll().size());
        assertEquals(UserUtil.user, userRepository.save(UserUtil.user));
        assertEquals(4, userRepository.getAll().size());
    }

    @Test
    public void testGet() throws Exception {
        assertEquals(UserUtil.user, userRepository.get(1));
    }

    @Test
    public void testDelete() throws Exception {
        assertEquals(3, userRepository.getAll().size());
        userRepository.delete(1);
        assertEquals(2, userRepository.getAll().size());
    }

    @Test
    public void testGetByEmail() throws Exception {
        assertEquals(UserUtil.user, userRepository.getByEmail("admin@email.com"));
    }
}