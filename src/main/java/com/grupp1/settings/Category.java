package com.grupp1.settings;



import javax.persistence.*;
import java.util.Set;

@Entity(name = "Category")
@Table (name = "category", uniqueConstraints = {
        @UniqueConstraint(columnNames = "category_id")})
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "category_id", unique = true)
    private int category_id;
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "concert_category",
            joinColumns = {@JoinColumn(name = "category_id")},
            inverseJoinColumns = { @JoinColumn(name = "concert_id")})
    private Set<Concert> concerts;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Concert> getConcerts() {
        return concerts;
    }

    public void setConcerts(Set<Concert> concerts) {
        this.concerts = concerts;
    }
}
