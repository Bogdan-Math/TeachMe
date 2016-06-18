package ua.teachme.web.notation;

import org.springframework.beans.factory.annotation.Autowired;
import ua.teachme.dto.NotationTO;
import ua.teachme.model.Notation;
import ua.teachme.model.User;
import ua.teachme.service.NotationService;
import ua.teachme.service.UserService;
import ua.teachme.util.notation.NotationUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

//todo: separate 'save' to 'create' and 'update' methods
public abstract class AbstractNotationController {

    @Autowired
    private UserService userService;

    @Autowired
    private NotationService notationService;

    public User getUser(int id) {
        return userService.get(id);
    }

    public List<Notation> getAll() {
        return notationService.getAll();
    }

    public Notation save(Notation notation) {
        return notationService.save(notation);
    }

    public Notation get(int id) {
        return notationService.get(id);
    }

    public void delete(int id) {
        notationService.delete(id);
    }

    public List<NotationTO> getBetween(int userId, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
        return NotationUtil.getFilteredNotationsExceedWithStreams(
                getByUserId(userId),
                startDate == null || startTime == null ? LocalDateTime.MIN : LocalDateTime.of(startDate, startTime),
                endDate == null || endTime == null ? LocalDateTime.MAX : LocalDateTime.of(endDate, endTime),
                NotationUtil.hours
        );
    }

    public void evictCache() {
        notationService.evictCache();
    }

    public List<Notation> getByUserId(int userId) {
        return notationService.getByUserId(userId);
    }
}