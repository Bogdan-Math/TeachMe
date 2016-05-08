package ua.teachme.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = User.DELETE, query = "DELETE FROM User user WHERE user.id=:id"),
        @NamedQuery(name = User.GET_ALL, query = "SELECT user FROM User user ORDER BY user.name, user.email"),
        @NamedQuery(name = User.BY_EMAIL, query = "SELECT user FROM User user WHERE user.email=:email")
})
@Entity
@Table(name = "users")
public class User extends EntityName {

    public static final String DELETE = "user.delete";
    public static final String GET_ALL = "user.getAll";
    public static final String BY_EMAIL = "user.getByEmail";

    @Column(name = "password", nullable = false)
    @NotEmpty
    @Length(min = 6)
    private String password;

    @Column(name = "email", nullable = false)
    @NotEmpty
    @Email
    private String email;

    @Column(name = "max_hours_per_day")
    private int maxHoursPerDay;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private MainGoal mainGoal;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Notation> notations;

    //todo set annotations to correct mapping
    @Transient()// - to ignore field
    private Set<Role> roles;

    @Column(name = "registered_date_and_time")
    private LocalDateTime registeredDateAndTime;

    public User() {}

    public User(User user){
        this(user.getId(), user.getName(), user.getPassword(), user.getEmail(), user.getMaxHoursPerDay(), user.getNotations(), user.getRoles());
    }

    public User(Integer id, String name, String password, String email, int maxHoursPerDay, List<Notation> notations, Role role, Role... roles){
        this(id, name, password, email, maxHoursPerDay, notations, EnumSet.of(role, roles));
    }

    public User(Integer id, String name, String password, String email, int maxHoursPerDay, List<Notation> notations, Set<Role> roles) {
        super(id, name);
        this.password = password;
        this.email = email;
        this.maxHoursPerDay = maxHoursPerDay;
        this.notations = notations;
        this.roles = roles;
        this.registeredDateAndTime = LocalDateTime.now();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMaxHoursPerDay() {
        return maxHoursPerDay;
    }

    public void setMaxHoursPerDay(int maxHoursPerDay) {
        this.maxHoursPerDay = maxHoursPerDay;
    }

    public MainGoal getMainGoal() {
        return mainGoal;
    }

    public void setMainGoal(MainGoal mainGoal) {
        this.mainGoal = mainGoal;
    }

    public List<Notation> getNotations() {
        return notations;
    }

    public void setNotations(List<Notation> notations) {
        this.notations = notations;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public LocalDateTime getRegisteredDateAndTime() {
        return registeredDateAndTime;
    }

    public void setRegisteredDateAndTime(LocalDateTime registeredDateAndTime) {
        this.registeredDateAndTime = registeredDateAndTime;
    }

    public LocalDate getRegisteredDate() {
        return registeredDateAndTime.toLocalDate();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", maxHoursPerDay=" + maxHoursPerDay +
                ", notations=" + notations +
                ", roles=" + roles +
                ", registeredDateAndTime=" + registeredDateAndTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return email.equals(user.email);

    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}
