package ua.teachme.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainGoalTO {

    private String name;
    private String description;

    public MainGoalTO() {
    }

    public MainGoalTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "MainGoalTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}