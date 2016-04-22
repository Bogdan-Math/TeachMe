package ua.teachme.web.notation;

import org.springframework.stereotype.Controller;
import ua.teachme.model.Notation;
import ua.teachme.dto.NotationExceed;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
public class NotationController extends AbstractNotationController{

    @Override
    public List<Notation> getAll() {
        return super.getAll();
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
