package ua.teachme.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class User extends EntityName {

    private String password;
    private String email;
    private int maxHoursPerDay;
    private List<Notation> notations;
    private Set<Role> roles;
    private LocalDate registeredDate;

    public User() {
        super();
    }

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
        this.registeredDate = LocalDate.now();
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
