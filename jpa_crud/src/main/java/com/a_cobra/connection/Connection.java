package com.a_cobra.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
    private static Connection connection = new Connection();
    private EntityManagerFactory factory;

    private Connection() {
        factory = Persistence.createEntityManagerFactory("JPA_CrudPU");
    }

    public static Connection getConnection() {
        return connection;
    }

    public EntityManagerFactory getFactory() {
        return factory;
    }

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}
