package com.todos.service;

import com.todos.entity.User;
import com.todos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.UUID;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        //user.setId(UUID.randomUUID().toString());
        user.setIsActive("ACTIVE");
        user.setLastAccessed(new Timestamp(System.currentTimeMillis()));
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return userRepository.save(user);
    }

    public User getUserById(String id){
        return userRepository.findById(id).orElse(null);
    }

    public User deleteUser(User user){
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        existingUser.setIsActive("INACTIVE");
        existingUser.setLastAccessed(new Timestamp(System.currentTimeMillis()));
        userRepository.save(existingUser);
        return existingUser;
    }

    public User updateUser(User user){
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setLastAccessed(new Timestamp(System.currentTimeMillis()));
        return userRepository.save(existingUser);
    }

}
