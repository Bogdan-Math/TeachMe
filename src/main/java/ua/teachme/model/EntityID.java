package ua.teachme.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import javax.persistence.*;

@MappedSuperclass
@Access(AccessType.FIELD)
@JsonAutoDetect(
        fieldVisibility = Visibility.ANY,
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE
)// need to disable methods vision in json, allow only fields vision
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
