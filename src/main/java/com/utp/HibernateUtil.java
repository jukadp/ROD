package com.utp;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
private static final SessionFactory sessionFactory;

static {
    try {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    } catch (Throwable ex) {
        System.err.println("Initial session factory creation failed" + ex);
        throw new ExceptionInInitializerError(ex);//HibernateUtil.java:14
    }
}

public static SessionFactory getSessionFactory() {
    return sessionFactory;
    }
}

  
