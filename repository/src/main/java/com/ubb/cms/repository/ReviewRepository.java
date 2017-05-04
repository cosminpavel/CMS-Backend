package com.ubb.cms.repository;

import com.ubb.cms.model.Review;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nascasergiualin on 03/05/2017.
 */
@Repository
public class ReviewRepository implements IRepository<Review> {
    private SessionFactory sessionFactory;

    @Autowired
    public ReviewRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Review entity) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
            session.close();
        } catch (HibernateException hibernateException) {
            System.out.println(hibernateException.getMessage());
        }
    }

    @Override
    public void delete(Integer key) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Review review = (Review) session.get(Review.class, key);
            session.delete(review);
            transaction.commit();
            session.close();
        } catch (HibernateException hibernateException) {
            System.out.println(hibernateException.getMessage());
        }
    }

    @Override
    public List<Review> getAll() {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            List<Review> list = (List<Review>) session.createCriteria(Review.class).list();
            transaction.commit();

            session.close();
            return list;
        } catch (HibernateException hibernateException) {
            System.out.println(hibernateException.getMessage());
        }
        return null;
    }

    @Override
    public Review findById(Integer key) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Review review = (Review) session.get(Review.class, key);
            transaction.commit();
            session.close();
            return review;
        } catch (HibernateException hibernateException) {
            System.out.println(hibernateException.getMessage());
        }
        return null;
    }

    @Override
    public void update(Integer key, Review newEntity) {
        try {
            this.delete(key);
            this.add(newEntity);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
