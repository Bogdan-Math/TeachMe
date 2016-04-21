package ua.teachme.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class User extends EntityName {

    private String password;
    private String email;
    private int maxHoursPerDay;
    private List<Notation> notations;
    private Set<Role> roles;
    private LocalDate registeredDate;

    public User(Integer id, String name, String password, String email, int maxHoursPerDay, Set<Role> roles, LocalDate registeredDate) {
        super(id, name);
        this.password = password;
        this.email = email;
        this.roles = roles;
        this.maxHoursPerDay = maxHoursPerDay;
        this.registeredDate = registeredDate;
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

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }
}
