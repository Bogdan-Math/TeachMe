package ua.teachme.web;

import ua.teachme.LoggedUser;
import ua.teachme.model.User;
import ua.teachme.web.user.UserController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//todo: delete this class after ALPHA-production
public class UserServlet extends HttpServlet {

    private UserController userController = IndexServlet.getSpringContext().getBean(UserController.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", userController.getAll());
        request.getRequestDispatcher("users.jsp").forward(request, response);
        //doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userID = Integer.parseInt(request.getParameter("userID"));
        User selectedUser = userController.get(userID);
        request.setAttribute("selectedUser", selectedUser);
        request.getRequestDispatcher("user.jsp").forward(request, response);
    }
}
