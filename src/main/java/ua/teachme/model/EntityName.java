package ua.teachme.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class EntityName extends EntityID {

    @Column(name = "name")
    protected String name;

    public EntityName() {
        super();
    }

    public EntityName(Integer id, String name) {
        super(id);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
