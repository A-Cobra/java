package com.a_cobra.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAConnection {
    private static JPAConnection connection = new JPAConnection();
    private EntityManagerFactory factory;
    private EntityManager entityManager;

    private JPAConnection() {
        factory = Persistence.createEntityManagerFactory("JPA_CrudPU");
        entityManager = factory.createEntityManager();
    }

    public static JPAConnection getConnection() {
        return connection;
    }

    public EntityManagerFactory getFactory() {
        return factory;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
