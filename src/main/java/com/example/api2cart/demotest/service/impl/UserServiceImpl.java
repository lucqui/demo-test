package com.example.api2cart.demotest.service.impl;

import com.example.api2cart.demotest.dao.UserRepository;
import com.example.api2cart.demotest.dto.UserDTO;
import com.example.api2cart.demotest.dto.mapper.UserMapper;
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
    public List<UserDTO> getAll() {
        return UserMapper.mapper.toDto((List<User>) userRepository.findAll());
    }

    @Override
    public UserDTO get(Long id) {
        return UserMapper.mapper.toDto(userRepository.findById(id).get());
    }

    @Override
    public void add(UserDTO entity) {
        userRepository.save(UserMapper.mapper.toEntity(entity));
    }

    @Override
    public void delete(UserDTO entity) {
        userRepository.delete(UserMapper.mapper.toEntity(entity));
    }

    @Override
    public void deleteById(Long entityId) {
        userRepository.deleteById(entityId);
    }

    @Override
    public void update(UserDTO entity) {
        userRepository.save(UserMapper.mapper.toEntity(entity));
    }
}