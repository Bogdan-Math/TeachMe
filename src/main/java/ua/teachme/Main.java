package ua.teachme;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.teachme.dto.NotationExceed;
import ua.teachme.util.UserUtil;
import ua.teachme.web.notation.NotationController;
import ua.teachme.web.user.UserController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello TeachMe Enterprise!");

        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
            System.out.println(Arrays.toString(context.getBeanDefinitionNames()));

            UserController userController = context.getBean(UserController.class);
            System.out.println(userController.save(UserUtil.users.get(0)));

            NotationController notationController = context.getBean(NotationController.class);

            List<NotationExceed> list = notationController.getBetween(
                    LocalDate.of(2016, Month.MARCH, 13), LocalTime.of(0, 0),
                    LocalDate.of(2016, Month.MARCH, 13), LocalTime.of(23, 0)
            );
            list.forEach(System.out::println);
        }
    }
}
