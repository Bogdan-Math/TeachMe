package ua.teachme.web.notation;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
//todo: add more requirements and checks to tests
public class NotationControllerTest extends AbstractNotationControllerTest{

    @Test
    public void testGetAll() throws Exception {
        super.getMockMvc()
                .perform(get("/notations"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testCreate() throws Exception {
        super.getMockMvc()
                .perform(get("/notations/create"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testUpdate() throws Exception {
        int id = 1000007;
        super.getMockMvc()
                .perform(get("/notations/update?id=" + id))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testSave() throws Exception {

    }

    @Test
    public void testFilter() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }
}