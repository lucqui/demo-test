package com.example.api2cart.demotest.service.impl;

import com.example.api2cart.demotest.dao.UserRepository;
import com.example.api2cart.demotest.model.User;
import com.example.api2cart.demotest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User get(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void add(User entity) {
        userRepository.save(entity);
    }

    @Override
    public void delete(User entity) {
        userRepository.delete(entity);
    }

    @Override
    public void deleteById(Long entityId) {
        userRepository.deleteById(entityId);
    }

    @Override
    public void update(User entity) {
        userRepository.save(entity);
    }
}