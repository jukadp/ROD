package com.model.imp;


import  com.model.AktualizacjaDanych;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.utp.HibernateUtil;



import com.model.inter.InterAktualizacjaDanych;

public class ImplAktualizacjaDanych implements InterAktualizacjaDanych {


    @Override
    public void add(AktualizacjaDanych aktualizacjaDanych) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(aktualizacjaDanych);
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
            AktualizacjaDanych aktualizacjaDanych = (AktualizacjaDanych) session.load(AktualizacjaDanych.class, new Long(id));
            session.delete(aktualizacjaDanych);
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
    public void update(AktualizacjaDanych aktualizacjaDanych) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(aktualizacjaDanych);
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

    public List<AktualizacjaDanych> getAll() {
        List<AktualizacjaDanych> users = new ArrayList<AktualizacjaDanych>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            users = session.createQuery("from AktualizacjaDanych").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }
    
   
    
    
    public AktualizacjaDanych getById(Long id_aktual_data) {
        AktualizacjaDanych aktualizacjaDanych = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from AktualizacjaDanych where id_aktual_data= :id_aktual_data";
            Query query = session.createQuery(queryString);
            query.setLong("id_aktual_data", id_aktual_data);
            aktualizacjaDanych = (AktualizacjaDanych) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return aktualizacjaDanych;
    }
   
}

