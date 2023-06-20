package com.a_cobra.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.a_cobra.connection.JPAConnection;
import com.a_cobra.models.User;

public class UserController {
    // NO ERRORS IN THIS CLASS
    private EntityManager getNewEntityManager() {
        return JPAConnection.getConnection().getEntityManager();
    }

    public void createUser(User user) {
        EntityManager entityManager = getNewEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("SOMETHING WENT WRONG");
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void updateUser(User user) {
        EntityManager entityManager = getNewEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public List<User> getAllUsers() {
        EntityManager entityManager = getNewEntityManager();
        String stringQuery = "SELECT u FROM User u";
        TypedQuery<User> query = entityManager.createQuery(stringQuery, User.class);
        return query.getResultList();
    }

    public void deleteUser(User user) {
        EntityManager entityManager = getNewEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }
}
