package com.ubb.cms.services;

import com.ubb.cms.model.User;
import com.ubb.cms.repository.UserRepository;

import java.util.List;

/**
 * Created by Raul on 24/04/2017.
 */
public class UserService
{
    private UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public List<User> getAll()
    {
       return userRepository.getAll();
    }

    public void addUser(int id, String username, String password, String email, String name, String surname, String tag)
    {
        userRepository.add(new User(id, username, password, email, name, surname, tag));
    }

    public void deleteUser(int key)
    {
        userRepository.delete(key);
    }

    public User findById(int key)
    {
        return userRepository.findById(key);
    }
}
