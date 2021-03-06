package com.ubb.cms.repository;

import com.ubb.cms.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by Raul on 24/04/2017.
 */
@Repository
public class UserRepository implements IRepository<User>{
    private SessionFactory sessionFactory;

    @Autowired
    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
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
