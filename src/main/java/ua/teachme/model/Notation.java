package ua.teachme.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Notation {

    private Integer id;
    private final String name;
    private final String url;
    private final String description;
    private final int hours;
    private final LocalDateTime dateTime;


    public Notation(String name, String url, String description, int hours, LocalDateTime dateTime){
        this(null, name, url, description, hours, dateTime);
    }

    public Notation(Integer id, String name, String url, String description, int hours, LocalDateTime dateTime) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.description = description;
        this.hours = hours;
        this.dateTime = dateTime;
    }

    public boolean isNew(){
        return id == null;
    }

    public Integer getId() {return id;}
    public void setId(Integer id){this.id = id;}

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public int getHours() {
        return hours;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public LocalDate getDate(){
        return dateTime.toLocalDate();
    }

    public LocalTime getTime(){
        return dateTime.toLocalTime();
    }

    @Override
    public String toString() {
        return "Notation{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", hours=" + hours +
                ", dateTime=" + dateTime +
                '}';
    }
}
