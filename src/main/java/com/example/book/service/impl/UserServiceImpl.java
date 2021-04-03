package com.example.book.service.impl;

import com.example.book.dto.request.UserRequest;
import com.example.book.dto.response.UserResponse;
import com.example.book.mapper.user.UserMapper;
import com.example.book.repository.UserRepository;
import com.example.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void save(UserRequest userRequest) {
        if (!userRepository.existsByNameOrEmail(userRequest.getName(), userRequest.getEmail())) {
            userRepository.save(userMapper.toUser(userRequest));
        }
    }

    @Override
    public UserResponse findById(Long id) {
        return userMapper.toUserRequest(userRepository.findById(id).get());
    }

    @Override
    public void update(UserRequest userRequest) {
        //TODO implement
    }

    @Override
    public UserResponse findByUsername(String username) {
        return userMapper.toUserRequest(userRepository.findByUsername(username));
    }
}
