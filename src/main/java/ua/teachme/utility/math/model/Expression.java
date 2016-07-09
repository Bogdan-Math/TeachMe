package ua.teachme.utility.math.model;

/*
     Expression class - main entity.
        key - contain unique table cell value ("A1", "F4" "D6", etc)
        value - contain math term, string or empty ( "1+2-B3", "'aaa", "", etc)
*/
public class Expression {

    private String key;
    private String value;

    public Expression(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Expression{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
