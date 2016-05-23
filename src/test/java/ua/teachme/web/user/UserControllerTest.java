package ua.teachme.web.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.teachme.model.User;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringJUnit4ClassRunner.class)
//todo: add more requirements and checks to tests
public class UserControllerTest extends AbstractUserControllerTest {

    @Test
    public void testGetAll() throws Exception {
        super.getMockMvc()
                .perform(get("/users"))
                .andDo(print());
    }

    @Test
    public void testGet() throws Exception {
        User user =  super.getUserController().get(1000001);
        user.getNotations().forEach(System.out::println);
    }

    @Test
    public void testGetByEmail() throws Exception {
        User user = super.getUserController().getByEmail("admin@gmail.com");
        user.getNotations().forEach(System.out::println);
    }
}