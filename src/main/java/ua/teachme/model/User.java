package ua.teachme.model;

import java.time.LocalDate;
import java.util.Set;

public class User extends EntityName {

    private String password;
    private String email;
    private int hours;
    private Set<Role> roles;
    private LocalDate registeredDate;

    public User(Integer id, String name, String password, String email, int hours, Set<Role> roles, LocalDate registeredDate) {
        super(id, name);
        this.password = password;
        this.email = email;
        this.roles = roles;
        this.hours = hours;
        this.registeredDate = registeredDate;
    }
}
