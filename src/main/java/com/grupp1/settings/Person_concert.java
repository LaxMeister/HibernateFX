package com.grupp1.settings;


import javax.persistence.*;

@Entity(name = "person_concert")
@Table(name = "person_concert")
public class Person_concert {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "concert_id", unique = false, nullable = false)
    private int concert_id;

    @Column(name = "person_id", unique = false, nullable = false)
    private int person_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConcert_id() {
        return concert_id;
    }

    public void setConcert_id(int concert_id) {
        this.concert_id = concert_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }
}
