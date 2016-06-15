package ua.teachme.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "main_goals")
public class MainGoal extends EntityName{

    @OneToOne/*(fetch = FetchType.LAZY)*/
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "description")
    private String description;

    public MainGoal(){}

    public MainGoal(String description){
        this.description = description;
    }
}
