package ua.teachme.web.user;

import org.junit.Test;
import ua.teachme.model.User;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

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
}