package ua.teachme;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.teachme.repository.NotationRepository;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello TeachMe Enterprise!");

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));

        //get bean by name
        NotationRepository notationRepository1 = (NotationRepository) context.getBean("notationRepository");
        System.out.println(notationRepository1);

        //get bean by class
        NotationRepository notationRepository2 = context.getBean(NotationRepository.class);
        System.out.println(notationRepository2);

        context.close();
    }


}
