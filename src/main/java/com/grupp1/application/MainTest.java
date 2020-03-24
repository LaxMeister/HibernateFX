package com.grupp1.application;


import com.grupp1.hibernate.HibernateUtil;

public class MainTest {

    public static void main(String[] args) {
//        Person person = new Person();
//        person.setName("Yeahsper");
//        person.setAge("16");
//        Person person1 = new Person();
//        person1.setName("Laxster");
//        person1.setAge("18");
////
//        Concert concert = new Concert();
//        concert.setArtist("Hentai Bois");
//        concert.setDate("2020-05-02 22:00:00");
//
//
//        Concert concert = new Concert();
//        concert.setArtist("bob Bois");
//        concert.setDate("2020-05-02 22:00:00");
//
//
//        Concert concert1 = new Concert();
//        concert1.setArtist("vagene Bois");
//        concert1.setDate("2020-05-02 22:00:00");
//
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
////        String hql = "from Concert where category.name = 'Pop'";
//        Query query = session.createQuery(hql);
//        List<Object[]> listResult = query.list();

//        session.getTransaction().commit();

        //Get Session
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //start transaction

        //Save the Model object

//        session.update(concert1);
//        session.save(person);
//        session.save(concert);
        //Commit transaction



        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionFactory().close();
    }
}
