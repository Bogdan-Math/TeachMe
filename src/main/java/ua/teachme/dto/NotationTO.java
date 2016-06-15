package ua.teachme.dto;

import lombok.Getter;
import lombok.Setter;
import ua.teachme.model.Notation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class NotationTO {

    private Integer id;
    private String name;
    private String url;
    private String description;
    private int hours;
    private LocalDateTime dateTime;
    private boolean exceed;

    public NotationTO(Integer id, String name, String url, String description, int hours, LocalDateTime dateTime, boolean exceed) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.description = description;
        this.hours = hours;
        this.dateTime = dateTime;
        this.exceed = exceed;
    }

    public NotationTO(Notation notation, boolean exceed) {
        this.id = notation.getId();
        this.name = notation.getName();
        this.url = notation.getUrl();
        this.description = notation.getDescription();
        this.hours = notation.getHours();
        this.dateTime = notation.getCreatedDateAndTime();
        this.exceed = exceed;
    }

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }

    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }

    @Override
    public String toString() {
        return "NotationTO{" +
                "id='" + id + '\''+
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", hours=" + hours +
                ", dateTime=" + dateTime +
                ", exceed=" + exceed +
                '}';
    }
}
