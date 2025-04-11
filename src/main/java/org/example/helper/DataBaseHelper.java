package org.example.helper;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.example.utils.HibernateUtil;

public class DataBaseHelper {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static Session getSession() {
        return sessionFactory.openSession();
    }

}
