package com.a_cobra.controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.a_cobra.models.User;

public class UserController {
    SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(User.class)
            .buildSessionFactory();

    public User createUser(
            String name,
            String lastname,
            String phone,
            String email,
            String password) {
        Session session = sessionFactory.openSession();
        try {
            // transient entity
            User user = new User(null, name, lastname, phone, email, password);
            Transaction tx = session.beginTransaction();
            session.persist(user);
            tx.commit();
            session.close();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return new User();
    }

    public boolean removeUser(long id) {
        Session session = sessionFactory.openSession();
        try {
            Transaction tx = session.beginTransaction();
            // managed entity
            User user = session.get(User.class, id);
            session.remove(user);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return false;
    }
}
