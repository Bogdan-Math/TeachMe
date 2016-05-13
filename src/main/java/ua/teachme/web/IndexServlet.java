package ua.teachme.web;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IndexServlet extends HttpServlet{

    private static WebApplicationContext springContext;

    @Override
    public void init() throws ServletException {
        super.init();
        springContext = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
    }

    @Override
    public void destroy() {
        //springContext.close();
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

    public static WebApplicationContext getSpringContext() {
        return springContext;
    }
}
