package com.model.imp;


import  com.model.KontoUzytkownika;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.utp.HibernateUtil;



import com.model.inter.InterKontoUzytkownika;

public class ImplKontoUzytkownika implements InterKontoUzytkownika {


    @Override
    public void add(KontoUzytkownika dostep) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(dostep);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
 
            session.close();
           
        }
    }

    @Override
    public void delete(Long id) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            KontoUzytkownika dostep = (KontoUzytkownika) session.load(KontoUzytkownika.class, new Long(id));
            session.delete(dostep);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {

            session.close();
        }
    }

           
      
    @Override
    public void update(KontoUzytkownika dostep) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(dostep);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
           // session.flush();
            session.close();
        }
    }

    public List<KontoUzytkownika> getAll() {
        List<KontoUzytkownika> users = new ArrayList<KontoUzytkownika>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            users = session.createQuery("from Dostep").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }
    
   
    
    
    public KontoUzytkownika getById(Long nr_dzialkowicza) {
        KontoUzytkownika dostep = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Dostep where nr_dzialkowicza= :nr_dzialkowicza";
            Query query = session.createQuery(queryString);
            query.setLong("nr_dzialkowicza", nr_dzialkowicza);
            dostep = (KontoUzytkownika) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return dostep;
    }
    
    
    public KontoUzytkownika getByLogin(String login) {
        KontoUzytkownika dostep = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Dostep where login= :login";
            Query query = session.createQuery(queryString);
            query.setString("login", login);
            dostep = (KontoUzytkownika) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return dostep;
    }
    
   
}

