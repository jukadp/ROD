package com.model.imp;


import  com.model.Wyciagi;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.utp.HibernateUtil;


import com.model.inter.InterWyciagi;


public class ImplWyciagi implements InterWyciagi {


    @Override
    public void add(Wyciagi wyciagiJs) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(wyciagiJs);
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
            Wyciagi wyciagiJs = (Wyciagi) session.load(Wyciagi.class, new Long(id));
            session.delete(wyciagiJs);
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
    public void update(Wyciagi wyciagiJs) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(wyciagiJs);
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

    public List<Wyciagi> getAll() {
        List<Wyciagi> users = new ArrayList<Wyciagi>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            users = session.createQuery("from WyciagiJs").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }
    
   
    
    
    public Wyciagi getById(Long nr_wyciagu) {
        Wyciagi wyciagiJs = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from WyciagiJs where nr_wyciagu= :nr_wyciagu";
            Query query = session.createQuery(queryString);
            query.setLong("nr_wyciagu", nr_wyciagu);
            wyciagiJs = (Wyciagi) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return wyciagiJs;
    }
   
}
