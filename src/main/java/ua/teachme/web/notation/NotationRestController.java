package ua.teachme.web.notation;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.teachme.dto.NotationExceed;
import ua.teachme.model.Notation;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Notation get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }

    @Override
    @RequestMapping(value = "/between", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NotationExceed> getBetween(
            @RequestParam(value = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(value = "startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime,
            @RequestParam(value = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(value = "endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime endTime
    ) {
        //todo: fix error !!!
        return super.getBetween(startDate, startTime, endDate, endTime);
    }
}
