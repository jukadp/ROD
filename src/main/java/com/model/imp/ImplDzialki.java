package com.model.imp;


import  com.model.Dzialki;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.utp.HibernateUtil;
import com.model.Dzialkowicz;


import com.model.inter.InterDzialki;


public class ImplDzialki implements InterDzialki {


    @Override
    public void add(Dzialki dzialki) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(dzialki);
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
            Dzialki dzialki = (Dzialki) session.load(Dzialki.class, new Long(id));
            session.delete(dzialki);
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
    public void update(Dzialki dzialki) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(dzialki);
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

    public List<Dzialki> getAll() {
        List<Dzialki> users = new ArrayList<Dzialki>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            users = session.createQuery("from Dzialki").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }
    
   
    
    
    public Dzialki getById(Long nr_dzialki) {
        Dzialki dzialki = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Dzialki where nr_dzialki= :nr_dzialki";
            Query query = session.createQuery(queryString);
            query.setLong("nr_dzialki", nr_dzialki);
            dzialki = (Dzialki) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return dzialki;
    }
    
    
       public Dzialki getByIdDzialkowicz(Long nr_czlonkowski)
   {
        Dzialki dzialki = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Dzialki where nr_czlonkowski= :nr_czlonkowski";
            Query query = session.createQuery(queryString);
            query.setLong("nr_czlonkowski", nr_czlonkowski);
            dzialki = (Dzialki) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return dzialki;
    }
    
}
