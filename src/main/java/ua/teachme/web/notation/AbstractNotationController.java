package ua.teachme.web.notation;

import org.springframework.beans.factory.annotation.Autowired;
import ua.teachme.dto.NotationTO;
import ua.teachme.model.Notation;
import ua.teachme.service.NotationService;
import ua.teachme.util.notation.NotationUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

//todo: separate 'save' to 'create' and 'update' methods
public abstract class AbstractNotationController {

    @Autowired
    private NotationService notationService;

    public List<Notation> getAll(){
        return notationService.getAll();
    }

    public Notation save(Notation notation){
        return notationService.save(notation);
    }

    public Notation get(int id){
        return notationService.get(id);
    }

    public void delete(int id){
        notationService.delete(id);
    }

    public List<NotationTO> getBetween(LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime){
        return NotationUtil.getFilteredNotationsExceedWithStreams(
                notationService.getBetween(
                        startDate == null ? LocalDate.MIN : startDate,
                        endDate == null ? LocalDate.MAX : endDate
                ),
                startTime == null ? LocalTime.MIN : startTime,
                endTime == null ? LocalTime.MAX : endTime,
                NotationUtil.hours
        );
    }

    public List<NotationTO> getBetween(LocalDate startDate, LocalDate endDate){
        return getBetween(startDate, LocalTime.MIN, endDate, LocalTime.MAX);
    }

    public void evictCache(){
        notationService.evictCache();
    }

    List<Notation> getByUserId(int userId){
        return notationService.getByUserId(userId);
    }
}