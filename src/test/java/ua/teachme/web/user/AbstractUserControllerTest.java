package ua.teachme.web.user;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import ua.teachme.profiles.db.ConnectTo;
import ua.teachme.profiles.db.WorkBy;
import ua.teachme.web.controllers.view.UserController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@ContextConfiguration({
        "classpath:spring/db-connect.xml",
        "classpath:spring/db-behaviour.xml",
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-mvc.xml"
})
@ActiveProfiles({ConnectTo.POSTGRESQL, WorkBy.JPA})
@WebAppConfiguration
@Transactional
public abstract class AbstractUserControllerTest {

    private static CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();

    static {
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
    }

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private UserController userController;

    private MockMvc mockMvc;

    @PostConstruct
    public void postConstruct() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .addFilter(characterEncodingFilter)
                .build();

        //todo: add logging
    }

    @PreDestroy
    public void PreDestroy() {

        //todo: add logging
    }

    @Before
    public void setUp() throws Exception {
        userController.evictCache();
    }

    @After
    public void tearDown() throws Exception {
        userController.evictCache();
    }


    public MockMvc getMockMvc() {
        return mockMvc;
    }

    public UserController getUserController() {
        return userController;
    }
}