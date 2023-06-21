package com.example.demo.repository;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class ConnectionUtils {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static EntityManager getEntityManager(){
        return entityManager;
    }
}
