package ua.teachme.model;

import javax.persistence.*;

@MappedSuperclass
@Access(AccessType.FIELD)
public class EntityID {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "global_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    protected Integer id;

    public EntityID() {
    }

    public EntityID(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isNew(){
        return id == null;
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
