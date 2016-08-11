package ua.teachme.repository;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/db-connect.xml", "classpath:spring/db-behaviour.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AbstractRepositoryTest {

}
