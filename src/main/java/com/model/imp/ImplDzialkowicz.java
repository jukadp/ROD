package com.model.imp;


import  com.model.Dzialkowicz;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.utp.HibernateUtil;


import com.model.inter.InterDzialkowicz;


public class ImplDzialkowicz implements InterDzialkowicz {


    @Override
    public void add(Dzialkowicz dzialkowicz) {
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
            Dzialkowicz dzialkowicz = (Dzialkowicz) session.load(Dzialkowicz.class, new Long(id));
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
    public void update(Dzialkowicz dzialkowicz) {
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

    public List<Dzialkowicz> getAll() {
        List<Dzialkowicz> users = new ArrayList<Dzialkowicz>();
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
    
   
    
    
    public Dzialkowicz getById(Long nr_dzialkowicza) {
        Dzialkowicz dzialkowicz = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Dzialkowicz where nr_dzialkowicza= :nr_dzialkowicza";
            Query query = session.createQuery(queryString);
            query.setLong("nr_dzialkowicza", nr_dzialkowicza);
            dzialkowicz = (Dzialkowicz) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return dzialkowicz;
    }
   
}
