package com.model.imp;


import  com.model.Wlasciciel;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.utp.HibernateUtil;


import com.model.inter.InterWlasciciel;


public class ImplWlasciciel implements InterWlasciciel {


    @Override
    public void add(Wlasciciel dzialkowicz) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            
            session.save(dzialkowicz);
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
            Wlasciciel dzialkowicz = (Wlasciciel) session.load(Wlasciciel.class, new Long(id));
            session.delete(dzialkowicz);
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
    public void update(Wlasciciel dzialkowicz) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(dzialkowicz);
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

    public List<Wlasciciel> getAll() {
        List<Wlasciciel> users = new ArrayList<Wlasciciel>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            users = session.createQuery("from Dzialkowicz").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();        
            session.close();
        }
        return users;
    }
    
   
    
    
    public Wlasciciel getById(Long nr_dzialkowicza) {
        Wlasciciel dzialkowicz = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Dzialkowicz where nr_dzialkowicza= :nr_dzialkowicza";
            Query query = session.createQuery(queryString);
            query.setLong("nr_dzialkowicza", nr_dzialkowicza);
            dzialkowicz = (Wlasciciel) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return dzialkowicz;
    }
   
}
