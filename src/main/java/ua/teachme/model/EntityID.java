package ua.teachme.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Access(AccessType.FIELD)
@JsonAutoDetect(
        fieldVisibility = Visibility.ANY,
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE
)// need to disable methods vision in json, allow only fields vision
@Getter
@Setter
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

    public boolean isNew(){
        return null == id;
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
