package com.a_cobra.controllers;

import java.util.List;
import java.util.Optional;

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

    public Optional<User> getUserById(Long id) {
        EntityManager entityManager = getEntityManager();
        User user = entityManager.find(User.class, id);
        return Optional.ofNullable(user);
    }

    public void deleteUser(User user) {
        if (user.getId() == null) {
            throw new IllegalArgumentException("User's id cannot be null");
        }
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            Optional<User> existingUser = getUserById(user.getId());
            if (existingUser.isPresent()) {
                entityManager.remove(existingUser.get());
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("SOMETHING WENT WRONG");
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
