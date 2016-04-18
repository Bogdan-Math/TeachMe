package ua.teachme.web;

import org.slf4j.Logger;
import ua.teachme.model.Notation;
import ua.teachme.repository.NotationRepository;
import ua.teachme.repository.NotationRepositoryInMemoryImpl;
import ua.teachme.util.NotationUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.slf4j.LoggerFactory.getLogger;

public class NotationServlet extends HttpServlet {

    private static final Logger LOG = getLogger(NotationServlet.class);
    private static NotationRepository notationRepository;

    @Override
    public void init() throws ServletException {
        super.init();
        notationRepository = new NotationRepositoryInMemoryImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            request.setAttribute("notations", NotationUtil.getFilteredWithExceed(notationRepository.getAll(), NotationUtil.HOURS_PER_DAY));
            request.getRequestDispatcher("/notations.jsp").forward(request, response);
            LOG.debug("forward to /notations.jsp with all notations");
        } else if ("delete".equals(action)) {
            notationRepository.delete(getIdFromRequest(request));
            response.sendRedirect("notations");
            LOG.debug("redirect to notations, notation id={}, action={}.", request.getParameter("id"), request.getParameter("action"));
        } else if ("create".equals(action)) {
            request.setAttribute("notation", new Notation(null, "", "", "", 0, LocalDateTime.now()));
            request.getRequestDispatcher("/edit.jsp").forward(request, response);
            LOG.debug("forward to /edit.jsp with new notation");
        } else if ("update".equals(action)) {
            request.setAttribute("notation", notationRepository.get(getIdFromRequest(request)));
            request.getRequestDispatcher("/edit.jsp").forward(request, response);
            LOG.debug("forward to /edit.jsp, notation id={}, action={}.", request.getParameter("id"), request.getParameter("action"));
        } else {
            response.sendRedirect("index.jsp");
            LOG.debug("redirect to /index.jsp wrong parameters");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        Notation notation = new Notation(
                id.isEmpty() ? null : Integer.valueOf(id),
                request.getParameter("name"),
                request.getParameter("url"),
                request.getParameter("description"),
                Integer.valueOf(request.getParameter("hours")),
                LocalDateTime.now()
        );
        notationRepository.save(notation);
        response.sendRedirect("notations");
        LOG.debug("redirect to /notations.jsp, save notation, id={}.", request.getParameter("id"));
    }

    private int getIdFromRequest(HttpServletRequest request) {
        return Integer.valueOf(request.getParameter("id"));
    }
}
