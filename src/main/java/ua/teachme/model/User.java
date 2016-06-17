package ua.teachme.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
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

    @Column(name = "email", nullable = false)
    @NotEmpty
    @Email
    private String email;

    @Column(name = "password", nullable = false)
    @NotEmpty
    @Length(min = 6)
    private String password;

    //todo: add enable/disable user
    //private boolean enable;

    @Column(name = "max_hours_per_day")
    private int maxHoursPerDay;

    //todo: add get/set mainGoal tests
    @OneToOne(/*fetch = FetchType.LAZY,*/ //todo: change to List<MainGoal> which will include List<Notation>
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    @JsonIgnore // help to avoid: recursion calls/out of memory/stack overflow/no session(hibernate) exceptions
    private MainGoal mainGoal;

    //todo: add get/set notations tests
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @JsonIgnore // help to avoid: recursion calls/out of memory/stack overflow/no session(hibernate) exceptions
    private List<Notation> notations;

    //todo: change to ManyToMany
    //todo: add get/set roles tests
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @JsonIgnore // help to avoid: recursion calls/out of memory/stack overflow/no session(hibernate) exceptions
    private Set<Role> roles;

    @Column(name = "registered_date_and_time")
    private LocalDateTime registeredDateAndTime;

    public User() {
        this.setRoles(Role.COMMON);
    }

    public User(User user){
        this(user.getId(), user.getName(), user.getPassword(), user.getEmail(), user.getMaxHoursPerDay());
        this.setRoles(Role.COMMON);
    }

    public User(Integer id, String name, String password, String email, int maxHoursPerDay, LocalDateTime registeredDateAndTime) {
        super(id, name);
        this.password = password;
        this.email = email;
        this.maxHoursPerDay = maxHoursPerDay;
        this.registeredDateAndTime = registeredDateAndTime;
        this.setRoles(Role.COMMON);
    }

    public User(Integer id, String name, String password, String email) {
        super(id, name);
        this.password = password;
        this.email = email;
        this.registeredDateAndTime = LocalDateTime.now();
        this.setRoles(Role.COMMON);
    }

    public User(Integer id, String name, String password, String email, int maxHoursPerDay, Set<Role> roles) {
        super(id, name);
        this.password = password;
        this.email = email;
        this.maxHoursPerDay = maxHoursPerDay;
        this.registeredDateAndTime = LocalDateTime.now();
        this.roles = roles;
    }

    public User(Integer id, String name, String password, String email, int maxHoursPerDay) {
        super(id, name);
        this.password = password;
        this.email = email;
        this.maxHoursPerDay = maxHoursPerDay;
        this.registeredDateAndTime = LocalDateTime.now();
        this.setRoles(Role.COMMON);
    }

    public User(String name, String password, String email, int maxHoursPerDay) {
        super(null, name);
        this.password = password;
        this.email = email;
        this.maxHoursPerDay = maxHoursPerDay;
        this.registeredDateAndTime = LocalDateTime.now();
        this.setRoles(Role.COMMON);
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

    public void setRoles(Role role, Role... roles) {
        this.roles = EnumSet.of(role, roles);
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
