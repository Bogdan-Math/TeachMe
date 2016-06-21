package ua.teachme.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    @Override
    public String toString() {
        return "UserTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", hours=" + hours +
                '}';
    }
}