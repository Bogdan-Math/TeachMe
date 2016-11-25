package ua.teachme.web.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.teachme.LoggedUser;
import ua.teachme.model.Notation;
import ua.teachme.utility.notation.NotationUtil;
import ua.teachme.utility.time.TimeUtil;
import ua.teachme.web.controllers.AbstractNotationController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Controller
@RequestMapping(value = "/notations")
public class NotationController extends AbstractNotationController {

    @RequestMapping(method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute(
                "notations",
                NotationUtil.getFilteredWithExceed(
                        super.getByUserId(LoggedUser.getId()),
                        NotationUtil.hours
                )
        );
        setDefaultDateAndTime(model);
        return "notations";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("notation", new Notation());
        return "notation";
    }

/*
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(HttpServletRequest request, Model model) {
        model.addAttribute("notation", super.get(getIdFromRequest(request)));
        return "notation";
    }
*/

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id, HttpServletRequest request, Model model) {
        model.addAttribute("notation", super.get(id));
        return "notation";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        Notation notation = new Notation(
                id.isEmpty() ? null : Integer.valueOf(id),
                request.getParameter("name"),
                request.getParameter("url"),
                request.getParameter("description"),
                Integer.valueOf(request.getParameter("hours")),
                id.isEmpty() ? LocalDateTime.now() : LocalDateTime.parse(request.getParameter("createdDateAndTime"))
        );
        notation.setUser(super.getUser(LoggedUser.getId()));
        super.save(notation);
        setDefaultDateAndTime(model);
        return "redirect:/notations";
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public String filter(HttpServletRequest request, Model model) {
        String startDate = request.getParameter("startDate");
        String startTime = request.getParameter("startTime");
        String endDate = request.getParameter("endDate");
        String endTime = request.getParameter("endTime");
        model.addAttribute("notations", super.getBetween(
                LoggedUser.getId(),
                TimeUtil.toLocalDate(startDate),
                TimeUtil.toLocalTime(startTime),
                TimeUtil.toLocalDate(endDate),
                TimeUtil.toLocalTime(endTime)
                )
        );

        model.addAttribute("startDate", startDate);
        model.addAttribute("startTime", startTime);
        model.addAttribute("endDate", endDate);
        model.addAttribute("endTime", endTime);

        setDefaultDateAndTime(model);
        return "notations";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id, HttpServletRequest request, Model model) {
        super.delete(id);
        setDefaultDateAndTime(model);
        return "redirect:/notations";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getByUserId(HttpServletRequest request, Model model){
        int userId = Integer.valueOf(request.getParameter("userId"));
        model.addAttribute
                (
                        "notations",
                        NotationUtil.getFilteredWithExceed
                                (
                                        super.getByUserId(userId),
                                        NotationUtil.hours)
                );
        setDefaultDateAndTime(model);
        return "notations";
    }

    private int getIdFromRequest(HttpServletRequest request) {
        return Integer.valueOf(request.getParameter("id"));
    }

    private void setDefaultDateAndTime(Model model){
        model.addAttribute("startDate", TimeUtil.TODAY);
        model.addAttribute("startTime", TimeUtil.MIN_TIME);
        model.addAttribute("endDate", TimeUtil.TODAY);
        model.addAttribute("endTime", TimeUtil.MAX_TIME);
    }
}