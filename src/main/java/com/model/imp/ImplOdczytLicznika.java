package com.model.imp;


import  com.model.OdczytLicznika;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.utp.HibernateUtil;


import com.model.inter.InterOdczytLicznika;

public class ImplOdczytLicznika implements InterOdczytLicznika {


    @Override
    public void add(OdczytLicznika odczytLicznika) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(odczytLicznika);
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
            OdczytLicznika odczytLicznika = (OdczytLicznika) session.load(OdczytLicznika.class, new Long(id));
            session.delete(odczytLicznika);
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
    public void update(OdczytLicznika odczytLicznika) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(odczytLicznika);
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

    public List<OdczytLicznika> getAll() {
        List<OdczytLicznika> users = new ArrayList<OdczytLicznika>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            users = session.createQuery("from OdczytLicznika").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }
    
   
    
    
    public OdczytLicznika getById(Long id_odczyt_licznika) {
        OdczytLicznika odczytLicznika = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from OdczytLicznika where id_odczyt_licznika= :id_odczyt_licznika";
            Query query = session.createQuery(queryString);
            query.setLong("id_odczyt_licznika", id_odczyt_licznika);
            odczytLicznika = (OdczytLicznika) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return odczytLicznika;
    }
   
}
