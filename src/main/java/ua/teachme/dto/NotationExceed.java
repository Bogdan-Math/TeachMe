package ua.teachme.dto;

import ua.teachme.model.Notation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class NotationExceed {

    private final Integer id;
    private final String name;
    private final String url;
    private final String description;
    private final int hours;
    private final LocalDateTime dateTime;
    private final boolean exceed;

    public NotationExceed(Integer id, String name, String url, String description, int hours, LocalDateTime dateTime, boolean exceed) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.description = description;
        this.hours = hours;
        this.dateTime = dateTime;
        this.exceed = exceed;
    }

    public NotationExceed(Notation notation, boolean exceed) {
        this.id = notation.getId();
        this.name = notation.getName();
        this.url = notation.getUrl();
        this.description = notation.getDescription();
        this.hours = notation.getHours();
        this.dateTime = notation.getCreatedDateAndTime();
        this.exceed = exceed;
    }

    public Integer getId() {return id;}

    public String getName() {return name;}

    public String getUrl() {return url;}

    public String getDescription() {return description;}

    public int getHours() {return hours;}

    public LocalDateTime getDateTime() {return dateTime;}

    public boolean isExceed() {return exceed;}

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }

    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }

    @Override
    public String toString() {
        return "NotationExceed{" +
                "id='" + id + '\''+
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", hours=" + hours +
                ", dateTime=" + dateTime +
                ", exceed=" + exceed +
                '}';
    }
}
