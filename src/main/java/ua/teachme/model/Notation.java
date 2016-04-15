package ua.teachme.model;

import java.time.LocalDateTime;

public class Notation {

    protected final String name;
    protected final String url;
    protected final String description;
    protected final int hours;
    protected final LocalDateTime dateTime;

    public Notation(String name, String url, String description, int hours, LocalDateTime dateTime) {
        this.name = name;
        this.url = url;
        this.description = description;
        this.hours = hours;
        this.dateTime = dateTime;
    }

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
