package ua.teachme.web.controllers.rest;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.teachme.LoggedUser;
import ua.teachme.dto.NotationTO;
import ua.teachme.model.Notation;
import ua.teachme.web.controllers.AbstractNotationController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping(value = "/rest/notations")
public class NotationRestController extends AbstractNotationController {

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Notation> getAll() {
        return super.getAll();
    }

    //todo: add 'save' to REST functionality
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
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @RequestMapping(value = "/betweenDateAndTime", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NotationTO> getBetween(
            @RequestParam(value = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(value = "startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime,
            @RequestParam(value = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(value = "endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime endTime
    ) {
        return super.getBetween(LoggedUser.getId(), startDate, startTime, endDate, endTime);
    }
}
