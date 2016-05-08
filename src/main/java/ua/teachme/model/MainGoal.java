package ua.teachme.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "main_goals")
public class MainGoal extends EntityName{

    @Column(name = "description")
    private String description;

    public MainGoal(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
