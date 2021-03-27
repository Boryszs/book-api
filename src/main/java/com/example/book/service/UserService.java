package com.example.book.service;

import com.example.book.dto.request.UserRequest;
import com.example.book.dto.response.UserResponse;

public interface UserService {

    void save(UserRequest userRequest);
    UserResponse findById(Long id);
    void update(UserRequest userRequest);
    UserResponse findByUsername(String username);

}
