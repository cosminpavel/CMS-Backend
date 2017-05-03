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
 * Created by nascasergiualin on 03/05/2017.
 */
public class ReviewRepository implements IRepository<Review>
{
    Configuration connection = null;
    ServiceRegistry serviceRegistry;
    SessionFactory sessionFactory;

    public ReviewRepository()
    {
        connection = new Configuration().configure("/hibernate.cfg.xml").addAnnotatedClass(Conference.class).addAnnotatedClass(Edition.class).addAnnotatedClass(ConferenceSession.class).addAnnotatedClass(User.class).addAnnotatedClass(SessionChair.class).addAnnotatedClass(Participation.class).addAnnotatedClass(Paper.class).addAnnotatedClass(Review.class);
        serviceRegistry = new ServiceRegistryBuilder().applySettings(connection.getProperties()).buildServiceRegistry();
        sessionFactory = connection.buildSessionFactory(serviceRegistry);
    }

    @Override
    public void add(Review entity)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
            session.close();
        }
        catch (HibernateException hibernateException)
        {
            System.out.println(hibernateException.getMessage());
        }
    }

    @Override
    public void delete(Integer key)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Review review = (Review) session.get(Review.class, key);
            session.delete(review);
            transaction.commit();
            session.close();
        }
        catch (HibernateException hibernateException)
        {
            System.out.println(hibernateException.getMessage());
        }
    }

    @Override
    public List<Review> getAll()
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            List<Review> list = (List<Review>) session.createCriteria(Review.class).list();
            transaction.commit();

            session.close();
            return list;
        }
        catch (HibernateException  hibernateException)
        {
            System.out.println(hibernateException.getMessage());
        }
        return null;
    }

    @Override
    public Review findById(Integer key)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Review review = (Review) session.get(Review.class, key);
            transaction.commit();
            session.close();
            return review;
        }
        catch (HibernateException hibernateException)
        {
            System.out.println(hibernateException.getMessage());
        }
        return null;
    }

    @Override
    public void update(Integer key, Review newEntity)
    {
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
}
