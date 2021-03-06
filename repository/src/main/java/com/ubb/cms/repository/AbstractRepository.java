package com.ubb.cms.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class AbstractRepository<T> implements IRepository<T> {
    protected SessionFactory sessionFactory;
    private final Class<T> managedEntity;

    public AbstractRepository(SessionFactory sessionFactory, Class<T> managedEntity) {
        this.sessionFactory = sessionFactory;
        this.managedEntity = managedEntity;
    }

    @Override
    public void add(T entity) {
        save(entity);
    }

    @Override
    public void delete(Integer key) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(findById(key));
        transaction.commit();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<T> list = (List<T>) session.createCriteria(managedEntity).list();
        transaction.commit();

        return list;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T findById(Integer key) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        Object obj = session.load(managedEntity, key);
        trans.commit();

        return obj == null ? null : (T) obj;
    }

    @Override
    public void update(T entity) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.update(entity);
        trans.commit();
    }

    @Override
    public void update(Integer key, T newEntity) {
        update(newEntity);
    }

    @Override
    public Serializable save(T entity) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        Serializable generatedId = session.save(entity);
        trans.commit();
        return generatedId;
    }
}
