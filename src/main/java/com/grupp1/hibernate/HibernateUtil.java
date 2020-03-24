package com.grupp1.hibernate;



import com.grupp1.settings.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    //XML based configuration
    private static SessionFactory sessionFactory;
    public static String user;
    public static String pass;

    private static SessionFactory buildSessionFactory() {


        try {
            user = "Lax_Admin";
            pass = "Admin123";
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.setProperty("hibernate.connection.url","jdbc:mysql://localhost/hibernatefx?serverTimezone=UTC");
            configuration.setProperty("hibernate.connection.username",user);
            configuration.setProperty("hibernate.connection.password",pass);
            configuration.addAnnotatedClass(Concert.class);
            configuration.addAnnotatedClass(Category.class);
            configuration.addAnnotatedClass(Category_concert.class);
            configuration.addAnnotatedClass(Person.class);
            configuration.addAnnotatedClass(Person_concert.class);


            System.out.println("Hibernate Configuration loaded");

            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
            serviceRegistryBuilder.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }



}