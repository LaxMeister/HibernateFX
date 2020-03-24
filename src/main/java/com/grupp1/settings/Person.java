package com.grupp1.settings;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="person")
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "person_id", unique = true)
    private int person_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private String age;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "person_concert",
            joinColumns = {@JoinColumn(name = "person_id")},
            inverseJoinColumns = { @JoinColumn(name = "concert_id")})
    private Set<Concert> concertsP;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public Set<Concert> getConcertsP() {
        return concertsP;
    }

    public void setConcertsP(Set<Concert> concertsP) {
        this.concertsP = concertsP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
