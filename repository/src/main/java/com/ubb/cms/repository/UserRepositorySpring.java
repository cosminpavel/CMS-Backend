package com.ubb.cms.repository;

import com.ubb.cms.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Marius Adam
 */
@Repository
public class UserRepositorySpring extends AbstractRepository<User> {
    @Autowired
    public UserRepositorySpring(SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }
}
