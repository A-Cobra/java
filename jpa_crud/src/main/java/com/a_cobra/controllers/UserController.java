package com.a_cobra.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.a_cobra.connection.Connection;
import com.a_cobra.models.User;

public class UserController {
    private EntityManager getNewEntityManager() {
        return Connection.getConnection().getEntityManager();
    }

    public void createUser(User user) {
        EntityManager entityManager = getNewEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entityManager);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void updateUser(User user) {
        EntityManager entityManager = getNewEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entityManager);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public List<User> getAllUsers() {
        EntityManager entityManager = getNewEntityManager();
        String stringQuery = "SELECT u FROM User u";
        TypedQuery<User> query = entityManager.createNamedQuery(stringQuery, User.class);
        return query.getResultList();
    }

    public void deleteUser(User user) {
        EntityManager entityManager = getNewEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }
}
