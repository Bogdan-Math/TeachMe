package ua.teachme.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class User extends EntityName {

    private Account account;

    private int maxHoursPerDay;

    //todo set annotations to correct mapping
    private List<Notation> notations;

    //todo set annotations to correct mapping
    private Set<Role> roles;

    private LocalDateTime registeredDateAndTime;

    public User() {
        super();
        this.account = new Account();
    }

    public User(User user){
        this(user.getId(), user.getName(), user.getAccount().getEmail(), user.getAccount().getPassword(),user.getMaxHoursPerDay(), user.getNotations(), user.getRoles());
    }

    public User(Integer id, String name, String email, String password, int maxHoursPerDay, List<Notation> notations, Role role, Role... roles){
        this(id, name, email, password, maxHoursPerDay, notations, EnumSet.of(role, roles));
    }

    public User(Integer id, String name, String email, String password, int maxHoursPerDay, List<Notation> notations, Set<Role> roles) {
        super(id, name);
        this.account.setEmail(email);
        this.account.setPassword(password);
        this.maxHoursPerDay = maxHoursPerDay;
        this.notations = notations;
        this.roles = roles;
        this.registeredDateAndTime = LocalDateTime.now();
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getEmail(){
        return account.getEmail();
    }

    public void setEmail(String email){
        account.setEmail(email);
    }

    public String getPassword(){
        return account.getPassword();
    }

    public void setPassword(String password){
        account.setPassword(password);
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
                ", password='" + account.getPassword() + '\'' +
                ", email='" + account.getEmail() + '\'' +
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

        return account.getEmail().equals(user.getAccount().getEmail());

    }

    @Override
    public int hashCode() {
        return account.getEmail().hashCode();
    }
}
