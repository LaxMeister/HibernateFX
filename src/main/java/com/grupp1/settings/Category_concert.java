package com.grupp1.settings;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "concert_category")
@Table(name = "concert_category")
public class Category_concert implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "category_id", unique = false, nullable = false)
    private int category_id;

    @Column(name = "concert_id", unique = false, nullable = false)
    private int concert_id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getConcert_id() {
        return concert_id;
    }

    public void setConcert_id(int concert_id) {
        this.concert_id = concert_id;
    }


}
