package com.model.imp;


import  com.model.Naleznosc;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.utp.HibernateUtil;


import com.model.inter.InterNaleznosc;

public class ImplNaleznosc implements InterNaleznosc {


    @Override
    public void add(Naleznosc zobowiazania) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(zobowiazania);
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
            Naleznosc zobowiazania = (Naleznosc) session.load(Naleznosc.class, new Long(id));
            session.delete(zobowiazania);
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
    public void update(Naleznosc zobowiazania) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(zobowiazania);
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

    public List<Naleznosc> getAll() {
        List<Naleznosc> users = new ArrayList<Naleznosc>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            users = session.createQuery("from Zobowiazania").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }
   
   
    
    
    public Naleznosc getById(Long nr_zobowiazania) {
        Naleznosc zobowiazania = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Zobowiazania where nr_zobowiazania= :nr_zobowiazania";
            Query query = session.createQuery(queryString);
            query.setLong("nr_zobowiazania", nr_zobowiazania);
            zobowiazania = (Naleznosc) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return zobowiazania;
    }
   
}
