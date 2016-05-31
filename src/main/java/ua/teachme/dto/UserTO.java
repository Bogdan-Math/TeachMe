package ua.teachme.dto;

public class UserTO {

    private int id;
    private String name;
    private String email;
    private String password;
    private int hours;

    public UserTO() {
    }

    public UserTO(int id, String name, String email, String password, int hours) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.hours = hours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}