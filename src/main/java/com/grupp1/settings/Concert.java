package com.grupp1.settings;


import javax.persistence.*;
import java.util.Set;

@Entity (name = "Concert")
@Table (name = "concert", uniqueConstraints = {
        @UniqueConstraint(columnNames = "concert_id")})
public class Concert {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "concert_id", unique = true, nullable = false)
    private int concert_id;

    @Column(name = "artist", nullable = false)
    private String artist;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToMany(mappedBy = "concerts")
    private Set<Category> categories;

    @ManyToMany(mappedBy = "concertsP")
    private Set<Person> persons;


    public int getConcert_id() {
        return concert_id;
    }

    public void setConcert_id(int concert_id) {
        this.concert_id = concert_id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }
}
