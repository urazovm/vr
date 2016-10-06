package ru.vashrekrut.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Copyright 2016 LabIt.com
 * Created by xpap on 9/23/16.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
