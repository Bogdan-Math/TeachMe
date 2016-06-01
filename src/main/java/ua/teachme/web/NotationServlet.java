package ua.teachme.web;

import ua.teachme.LoggedUser;
import ua.teachme.model.Notation;
import ua.teachme.util.notation.NotationUtil;
import ua.teachme.util.time.TimeUtil;
import ua.teachme.web.notation.NotationController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

//todo: delete this class after ALPHA-production
public class NotationServlet extends HttpServlet {

    private NotationController notationController = IndexServlet.getSpringContext().getBean(NotationController.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            request.setAttribute("notations", NotationUtil.getFilteredWithExceed(notationController.getAll(), NotationUtil.hours));
            setDefaultDateAndTime(request);
            request.getRequestDispatcher("/notations.jsp").forward(request, response);
        }
        else if ("delete".equals(action)) {
            notationController.delete(getIdFromRequest(request));
            response.sendRedirect("notations");
            setDefaultDateAndTime(request);
        }
        else if ("create".equals(action)) {
            request.setAttribute("notation", new Notation("", "", "", 0, LocalDateTime.now()));
            request.getRequestDispatcher("/notation.jsp").forward(request, response);
        }
        else if ("update".equals(action)) {
            request.setAttribute("notation", notationController.get(getIdFromRequest(request)));
            request.getRequestDispatcher("/notation.jsp").forward(request, response);
        }
        else {
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (null == action) {
            String id = request.getParameter("id");
            Notation notation = new Notation(
                    id.isEmpty() ? null : Integer.valueOf(id),
                    request.getParameter("name"),
                    request.getParameter("url"),
                    request.getParameter("description"),
                    Integer.valueOf(request.getParameter("hours")),
                    id.isEmpty() ? LocalDateTime.now() : LocalDateTime.parse(request.getParameter("createdDateAndTime"))
            );
            notationController.save(notation);
            response.sendRedirect("notations");
        }
        else if ("filter".equals(action)) {
            String startDate = request.getParameter("startDate");
            String startTime = request.getParameter("startTime");
            String endDate = request.getParameter("endDate");
            String endTime = request.getParameter("endTime");
            request.setAttribute("notations", notationController.getBetween(
                    LoggedUser.getId(),
                    TimeUtil.toLocalDate(startDate),
                    TimeUtil.toLocalTime(startTime),
                    TimeUtil.toLocalDate(endDate),
                    TimeUtil.toLocalTime(endTime)
                    )
            );
            request.setAttribute("startDate", startDate);
            request.setAttribute("startTime", startTime);
            request.setAttribute("endDate", endDate);
            request.setAttribute("endTime", endTime);

            request.getRequestDispatcher("/notations.jsp").forward(request, response);
        }
        else {
            response.sendRedirect("notations");
        }
    }

    private int getIdFromRequest(HttpServletRequest request) {
        return Integer.valueOf(request.getParameter("id"));
    }
    private void setDefaultDateAndTime(HttpServletRequest request){
        request.setAttribute("startDate", TimeUtil.TODAY);
        request.setAttribute("startTime", TimeUtil.MIN_TIME);
        request.setAttribute("endDate", TimeUtil.TODAY);
        request.setAttribute("endTime", TimeUtil.MAX_TIME);
    }
}
