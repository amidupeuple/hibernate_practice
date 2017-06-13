package pesiykot.entity;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dpivovar on 13.06.2017.
 */
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    private int height;

    private double weight;

    @ManyToMany
    @JoinTable(
            name = "person_community",
            joinColumns = {@JoinColumn(name = "fk_person")},
            inverseJoinColumns =  {@JoinColumn(name = "fk_community")}
    )
    private List<Community> communityList = new ArrayList<Community>();

    public List<Community> getCommunityList() {
        return communityList;
    }

    public void setCommunityList(List<Community> communityList) {
        this.communityList = communityList;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getFullName() {
        return firstName + " " + secondName;
    }
}
