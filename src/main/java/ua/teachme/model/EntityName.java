package ua.teachme.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
