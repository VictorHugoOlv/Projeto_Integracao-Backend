package org.example.helper;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.example.utils.HibernateUtil;
import static org.example.utils.HibernateUtil.threadLocalSession;

public class DataBaseHelper {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static Session getSession() {
        Session session = threadLocalSession.get();
        if (session == null || !session.isOpen()) {

            if (sessionFactory == null)
                return null;

            session = sessionFactory.openSession();
            threadLocalSession.set(session);

        }
        return session;
    }

}
