package org.example.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        try {
            sessionFactory = new Configuration()
                    .configure()
                    .buildSessionFactory();
            System.out.println("SessionFactory criado com sucesso: " + sessionFactory);
        } catch (Throwable ex) {
            System.err.println("Falha ao criar o SessionFactory." + ex);
        }

        return sessionFactory;
    }
}
