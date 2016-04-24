package ua.teachme.web;

import org.springframework.context.ConfigurableApplicationContext;
import ua.teachme.SelectedUser;
import ua.teachme.model.User;
import ua.teachme.web.user.UserController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    private UserController userController = IndexServlet.getSpringContext().getBean(UserController.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userID = Integer.parseInt(request.getParameter("userID"));
        SelectedUser.setID(userID);
        User selectedUser = userController.get(SelectedUser.getID());
        request.getRequestDispatcher("user.jsp").forward(request, response);
    }
}
