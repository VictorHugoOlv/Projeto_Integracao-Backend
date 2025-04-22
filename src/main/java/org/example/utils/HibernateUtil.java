package org.example.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static  SessionFactory sessionFactory;

    public static final ThreadLocal<Session> threadLocalSession = new ThreadLocal<>();

    public static SessionFactory getSessionFactory() {
        try {
            sessionFactory = new Configuration()
                    .configure()
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Falha ao criar o SessionFactory." + ex);
        }

        return sessionFactory;
    }
}
