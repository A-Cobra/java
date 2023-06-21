package com.a_cobra.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.a_cobra.connection.JPAConnection;
import com.a_cobra.models.User;

public class UserController {
    private EntityManager getEntityManager() {
        return JPAConnection.getConnection().getEntityManager();
    }

    public void createUser(User user) {
        if (user.getId() != null) {
            throw new IllegalArgumentException(
                    "User id is automatically set by the API, please sen the user without id");
        }
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void updateUser(User user) {
        if (user.getId() == null) {
            throw new IllegalArgumentException("User's id cannot be null");
        }
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public List<User> getAllUsers() {
        EntityManager entityManager = getEntityManager();
        String stringQuery = "SELECT u FROM User u";
        TypedQuery<User> query = entityManager.createQuery(stringQuery, User.class);
        return query.getResultList();
    }

    public void deleteUser(User user) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }
}
