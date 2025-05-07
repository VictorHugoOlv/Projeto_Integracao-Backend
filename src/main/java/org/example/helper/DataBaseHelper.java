package org.example.helper;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.example.utils.HibernateUtil;

public class DataBaseHelper {
    private static final DataBaseHelper instance = new DataBaseHelper();
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static Session session;

    private DataBaseHelper() {}

    public static DataBaseHelper getInstance() {
        if (session == null || !session.isOpen()) {
            session = sessionFactory.openSession();
        }

        return instance;
    }

    public static Session getSession() {
        return session;
    }

    public void shutdown() {
        if (sessionFactory != null)
            sessionFactory.close();
    }
}
