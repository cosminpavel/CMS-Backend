package com.ubb.cms.repository;

import com.ubb.cms.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


import java.util.List;


/**
 * Created by Raul on 24/04/2017.
 */
public class UserRepository implements IRepository<User>{
    Configuration connection = null;
    ServiceRegistry serviceRegistry;
    SessionFactory sessionFactory;

    public UserRepository()
    {

        connection = new Configuration().configure("/hibernate.cfg.xml").addAnnotatedClass(Conference.class).addAnnotatedClass(Edition.class).addAnnotatedClass(ConferenceSession.class).addAnnotatedClass(User.class).addAnnotatedClass(SessionChair.class).addAnnotatedClass(Participation.class).addAnnotatedClass(Paper.class).addAnnotatedClass(Review.class);
        serviceRegistry = new ServiceRegistryBuilder().applySettings(connection.getProperties()).buildServiceRegistry();
        sessionFactory = connection.buildSessionFactory(serviceRegistry);

    }

    public void add(User user)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            session.close();
        }
        catch (HibernateException hibernteException)
        {
            System.out.println(hibernteException.getMessage());
        }
    }

    public List<User> getAll()
    {

        try
        {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            List<User> list = (List<User>) session.createCriteria(User.class).list();
            transaction.commit();

            session.close();
            return list;
        }
        catch (HibernateException  hibernteException)
        {
            System.out.println(hibernteException.getMessage());
        }

        return null;
    }


    @Override
    public User findById(Integer key)
    {

        try
        {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            User user = (User)session.get(User.class, key);
            transaction.commit();
            session.close();
            return user;
        }
        catch (HibernateException hibernteException)
        {
            System.out.println(hibernteException.getMessage());
        }
        return null;


    }

    @Override
    public void update(Integer key, User newEntity) {
        try
        {
            this.delete(key);
            this.add(newEntity);
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void delete(Integer key)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            User user = (User)session.get(User.class, key);
            session.delete(user);
            transaction.commit();
            session.close();
        }
        catch (HibernateException  hibernteException)
        {
            System.out.println(hibernteException.getMessage());
        }

    }
}