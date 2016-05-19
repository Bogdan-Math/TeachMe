package ua.teachme.web.notation;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.teachme.dto.NotationExceed;
import ua.teachme.model.Notation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping(value = "/rest/notations")
public class NotationRestController extends AbstractNotationController{

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
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

    @Override
    public void evictCache() {
        super.evictCache();
    }
}
