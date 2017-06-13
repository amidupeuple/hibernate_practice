package pesiykot.entity;

/**
 * Created by dpivovar on 13.06.2017.
 */
public class PersonProjection {
    private String firstName;

    private String secondName;

    public PersonProjection(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFullName() {
        return firstName + " " + secondName;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
