package pesiykot.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dpivovar on 13.06.2017.
 */
@Entity
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "is_aggressive")
    private int isAggressive;

    @ManyToMany(mappedBy = "communityList")
    private List<Person> personList = new ArrayList<Person>();

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsAggressive() {
        return isAggressive;
    }

    public void setIsAggressive(int isAggressive) {
        this.isAggressive = isAggressive;
    }
}
