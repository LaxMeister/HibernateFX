package com.grupp1.hibernate;


import com.grupp1.settings.Concert;
import com.grupp1.settings.Person;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CriteriaHib {
    public static Concert concert = new Concert();


    @SuppressWarnings("all")
    public static void getCriteriaID(String artistName) {
        int id;
        String theID;

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select concert_id from concert where (concert.artist='"+ artistName+"')");
        List results = query.list();
        id = (int) results.get(0);
        concert.setConcert_id(id);
        System.out.println(id);
        session.getTransaction().commit();

    }
    @SuppressWarnings("all")
    public static void getArtist(ObservableList observableList){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(Concert.class);
        List<Concert> results = criteria.list();
        for (Concert con:results){
            observableList.add(con);
        }
        session.getTransaction().commit();
    }

    @SuppressWarnings("all")
    public static void getPerson(ObservableList observableList){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(Person.class);
        List<Person> results = criteria.list();
        for (Person per:results){
            observableList.add(per);
        }
        session.getTransaction().commit();
    }


    @SuppressWarnings("all")

    public static void getArtistFromGenre(int categoryId, ObservableList observableList, TextArea textField) {


        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT p FROM Category t JOIN t.concerts p WHERE t.category_id =" + categoryId);


        List<Concert> concertTests = (List<Concert>) query.getResultList();
        for (Concert con : concertTests) {
            observableList.addAll(con);

            System.out.println(con.getArtist() + " - " + con.getDate());
        }
        session.getTransaction().commit();

    }

    public static void getPersonsGoing(int concertID, ObservableList observableList) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT p FROM Concert t JOIN t.persons p WHERE t.concert_id =" + concertID);

        List<Person> concertTests = (List<Person>) query.getResultList();
        for (Person per : concertTests) {
            observableList.addAll(per);

            System.out.println(per.getName() + " - " + per.getAge());
        }
        session.getTransaction().commit();

    }

    public static void getAllConcerts( ObservableList observableList) {


        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Concert");


        List<Concert> concertTests = (List<Concert>) query.getResultList();
        for (Concert con : concertTests) {
            observableList.addAll(con);

            System.out.println(con.getArtist() + " - " + con.getDate());
        }
        session.getTransaction().commit();

    }


    public static void getDescription(String nameString, TextArea textField) {


        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Concert WHERE artist like concat('%',:studentName,'%')");
        query.setParameter("studentName", nameString);

        List<Concert> concertTests = (List<Concert>) query.getResultList();
        for (Concert con : concertTests) {
            textField.setText(con.getDescription());

            System.out.println(con.getArtist() + " - " + con.getDate());
        }
        session.getTransaction().commit();

    }

    public static void getSearchResult(String searchString, ObservableList observableList) {


        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Concert WHERE artist like concat('%',:studentName,'%')");
        query.setParameter("studentName", searchString);

//        query.setParameter("firstName", "5");
        List<Concert> concertTests = (List<Concert>) query.getResultList();
        for (Concert con : concertTests) {
            observableList.addAll(con);

            System.out.println(con.getArtist() + " - " + con.getDate());
        }
        session.getTransaction().commit();

    }
}
