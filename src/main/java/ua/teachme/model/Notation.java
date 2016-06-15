package ua.teachme.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = Notation.DELETE, query = "DELETE FROM Notation notation WHERE notation.id=:id"),
        @NamedQuery(name = Notation.GET_ALL, query = "SELECT notation FROM Notation notation ORDER BY notation.createdDateAndTime"),
        @NamedQuery(name = Notation.GET_BETWEEN, query = "SELECT notation FROM Notation notation WHERE :startDateAndTime <= notation.createdDateAndTime AND notation.createdDateAndTime <= :endDateAndTime ORDER BY notation.createdDateAndTime"),
        @NamedQuery(name = Notation.GET_BY_USER_ID, query = "SELECT notation FROM Notation notation WHERE notation.user.id=:userId ORDER BY notation.createdDateAndTime")
})
@Entity
@Table(name = "notations")
public class Notation extends EntityName {

    public static final String DELETE = "notation.delete";
    public static final String GET_ALL = "notation.getAll";
    public static final String GET_BETWEEN = "notation.getBetween";
    public static final String GET_BY_USER_ID = "notation.getByUserId";

    @ManyToOne/*(fetch = FetchType.LAZY)*/
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    @Column(name = "url")
    @NotEmpty
    //@URL//todo insert valid url
    private String url;

    @Column(name = "description")
    @NotEmpty
    private String description;

    @Column(name = "hours")
    @NotNull
    private int hours;

    @Column(name = "created_date_and_time")
    private LocalDateTime createdDateAndTime;

    public Notation(){}

    public Notation(Notation notation){
        this(notation.getName(), notation.getUrl(), notation.getDescription(), notation.getHours(), notation.getCreatedDateAndTime());
    }

    public Notation(String name, String url, String description, int hours, LocalDateTime createdDateAndTime){
        this(null, name, url, description, hours, createdDateAndTime);
    }

    public Notation(Integer id, String name, String url, String description, int hours, LocalDateTime createdDateAndTime) {
        super(id, name);
        this.url = url;
        this.description = description;
        this.hours = hours;
        this.createdDateAndTime = createdDateAndTime;
    }

    public LocalDate getDate(){
        return createdDateAndTime.toLocalDate();
    }

    public LocalTime getTime(){
        return createdDateAndTime.toLocalTime();
    }

    @Override
    public String toString() {
        return "Notation{" +
                "name=" + name +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", hours=" + hours +
                ", createdDateAndTime=" + createdDateAndTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notation)) return false;

        Notation notation = (Notation) o;

        return url.equals(notation.url);

    }

    @Override
    public int hashCode() {
        return url.hashCode();
    }
}
