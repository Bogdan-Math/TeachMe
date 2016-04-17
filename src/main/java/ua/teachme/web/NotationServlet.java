package ua.teachme.web;

import org.slf4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class NotationServlet extends HttpServlet {

    private static final Logger LOG = getLogger(NotationServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("redirect to notations");
        //request.getRequestDispatcher("/notationList.jsp").forward(request, response);
        response.sendRedirect("notationList.jsp");
    }

}
