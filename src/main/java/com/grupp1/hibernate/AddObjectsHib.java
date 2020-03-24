package com.grupp1.hibernate;


import com.grupp1.settings.Category_concert;
import com.grupp1.settings.Concert;
import com.grupp1.settings.Person;
import com.grupp1.settings.Person_concert;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.Set;

public class AddObjectsHib {

    public static void AddPerson(String name, String age, String description) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        person.setDescription(description);

        //Get Session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(person);
        //Commit transaction
        session.getTransaction().commit();

        System.out.println("Person: " + name + " " + "Age: " + age + " Added!");


    }

    public static void AddConcert(String artist, String date, int cat_id, String description) {
        Concert concert = new Concert();
        concert.setArtist(artist);
        concert.setDate(date);
        concert.setDescription(description);

        Set<Concert> concertTests = new HashSet<Concert>();
        concertTests.add(concert);


        //Get Session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(concert);
        //Commit transaction
        session.getTransaction().commit();

        System.out.println("Artist: " + artist + " " + "Date: " + date + " Added!");

    }

    public static void AddCategory(int categoryId, int concertID) {
        Category_concert category = new Category_concert();
        category.setConcert_id(concertID);
        category.setCategory_id(categoryId);

        //Get Session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
         session.persist(category);
        //Commit transaction
        session.getTransaction().commit();

        System.out.println("Category: " + categoryId + " " + "Concert: " + concertID + " Added!");

    }

    public static void Addgoing(int personId, int concertID) {
        Person_concert person_concert = new Person_concert();
        person_concert.setConcert_id(concertID);
        person_concert.setPerson_id(personId);

        //Get Session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.persist(person_concert);
        //Commit transaction
        session.getTransaction().commit();

        System.out.println("Category: " +personId + " " + "Concert: " + concertID + " Added!");

    }



}
