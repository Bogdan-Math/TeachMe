package ua.teachme.web;

import ua.teachme.SelectedUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("userID");
        SelectedUser.setID(Integer.parseInt(userID));
        request.setAttribute("userID", SelectedUser.getID());
        request.getRequestDispatcher("user.jsp").forward(request, response);
    }
}
