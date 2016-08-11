package ua.teachme.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ua.teachme.repository.AbstractRepositoryTest;
import ua.teachme.repository.UserRepository;
import ua.teachme.utility.user.UserUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AbstractUserRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testUserRepository(){
        assertNotNull(userRepository);
    }

    @Test
    public void testGetAll() throws Exception {
        assertEquals(3, userRepository.getAll().size());
    }

    @Test
    public void testSave() throws Exception {
        assertEquals(3, userRepository.getAll().size());
        assertEquals(UserUtil.equalUser, userRepository.save(UserUtil.newUser));
        assertEquals(4, userRepository.getAll().size());
    }

    @Test
    public void testGet() throws Exception {
        assertEquals(UserUtil.anonymous, userRepository.get(1000001));
    }

    @Test
    public void testDelete() throws Exception {
        assertEquals(3, userRepository.getAll().size());
        userRepository.delete(1000001);
        assertEquals(2, userRepository.getAll().size());
    }

    @Test
    public void testGetByEmail() throws Exception {
        assertEquals(UserUtil.admin, userRepository.getByEmail("admin@gmail.com"));
    }
}
