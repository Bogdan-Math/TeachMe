package ua.teachme.model;

import javax.persistence.*;

@Entity
@Table(name = "main_goals")
public class MainGoal extends EntityName{

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

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
