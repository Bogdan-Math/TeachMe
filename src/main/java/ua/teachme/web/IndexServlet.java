package ua.teachme.web;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ua.teachme.profiles.ConnectTo;
import ua.teachme.profiles.WorkBy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IndexServlet extends HttpServlet{

    private static GenericXmlApplicationContext springContext;

    @Override
    public void init() throws ServletException {
        super.init();
        springContext = new GenericXmlApplicationContext();
        springContext.getEnvironment().setActiveProfiles(ConnectTo.POSTGRESQL, WorkBy.JPA);
        springContext.load("spring/spring-app.xml", "spring/db-connect.xml", "spring/db-behaviour.xml");
        springContext.refresh();
    }


    @Override
    public void destroy() {
        springContext.close();
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/notations.jsp");
    }

    public static ConfigurableApplicationContext getSpringContext() {
        return springContext;
    }
}
