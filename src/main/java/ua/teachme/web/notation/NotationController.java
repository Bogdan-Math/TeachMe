package ua.teachme.web.notation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.teachme.model.Notation;
import ua.teachme.dto.NotationExceed;
import ua.teachme.util.notation.NotationUtil;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping(value = "/notations")
public class NotationController extends AbstractNotationController{

    @RequestMapping(method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("notations", NotationUtil.getFilteredWithExceed(super.getAll(), NotationUtil.hours));
        return "notations";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(HttpServletRequest request, Model model) {
        model.addAttribute("notation", super.get(getIdFromRequest(request)));
        return "notation";
    }

    @Override
    public Notation save(Notation notation) {
        return super.save(notation);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(HttpServletRequest request) {
        super.delete(getIdFromRequest(request));
        return "redirect:/notations";
    }

    @Override
    public List<NotationExceed> getBetween(LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
        return super.getBetween(startDate, startTime, endDate, endTime);
    }

    private int getIdFromRequest(HttpServletRequest request) {
        return Integer.valueOf(request.getParameter("id"));
    }
}
