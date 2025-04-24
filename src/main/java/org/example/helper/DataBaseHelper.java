package org.example.helper;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.example.utils.HibernateUtil;

public class DataBaseHelper {
    private static final DataBaseHelper instance = new DataBaseHelper();
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    public static Session session;

    private DataBaseHelper() {
    }

    public static DataBaseHelper getInstance() {
        if (instance == null)
            return new DataBaseHelper();

        return instance;
    }

    public static Session getSession() {
        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                return null;
            }

            session = sessionFactory.openSession();
        }
        return session;
    }

    public void shutdown() {
        if (sessionFactory != null)
            sessionFactory.close();
    }
}
