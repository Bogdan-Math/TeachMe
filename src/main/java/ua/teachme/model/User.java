package ua.teachme.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private LocalDateTime registeredDateAndTime;

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
