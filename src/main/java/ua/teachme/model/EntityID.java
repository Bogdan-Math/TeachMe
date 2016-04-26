package ua.teachme.model;

public class EntityID {

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
