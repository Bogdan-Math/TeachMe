package ua.teachme.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Notation extends EntityName{

    private String url;
    private String description;
    private int hours;
    private LocalDateTime dateTime;

    public Notation(String name, String url, String description, int hours, LocalDateTime dateTime){
        this(null, name, url, description, hours, dateTime);
    }

    public Notation(Integer id, String name, String url, String description, int hours, LocalDateTime dateTime) {
        super(id, name);
        this.url = url;
        this.description = description;
        this.hours = hours;
        this.dateTime = dateTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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
                super.toString() +
                "url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", hours=" + hours +
                ", dateTime=" + dateTime +
                '}';
    }
}
