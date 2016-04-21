package ua.teachme;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.teachme.model.Notation;
import ua.teachme.repository.NotationRepository;
import ua.teachme.service.NotationService;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello TeachMe Enterprise!");

        try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {

            System.out.println(Arrays.toString(context.getBeanDefinitionNames()));

/*            //get bean by name

            NotationRepository notationRepository1 = (NotationRepository) context.getBean("notationRepository");
            System.out.println(notationRepository1.save(new Notation("name1", "url1", "desc1", 0, LocalDateTime.now())));
*/

            //get bean by class
            NotationRepository notationRepository2 = context.getBean(NotationRepository.class);
            System.out.println("repository " + notationRepository2.save(new Notation("name2", "url2", "desc2", 0, LocalDateTime.now())));

            NotationService notationService = context.getBean(NotationService.class);
            System.out.println("service " + notationService.save(new Notation("name2", "url2", "desc2", 0, LocalDateTime.now())));
        }
    }
}
