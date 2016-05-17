package ua.teachme.web.notation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.teachme.model.Notation;
import ua.teachme.dto.NotationExceed;
import ua.teachme.util.notation.NotationUtil;

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

    @Override
    public Notation save(Notation notation) {
        return super.save(notation);
    }

    @Override
    public Notation get(int id) {
        return super.get(id);
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }

    @Override
    public List<NotationExceed> getBetween(LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
        return super.getBetween(startDate, startTime, endDate, endTime);
    }
}
