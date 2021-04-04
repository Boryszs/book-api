package com.example.book.service;

import com.example.book.dto.request.UserRequest;
import com.example.book.dto.response.UserResponse;
import com.example.book.exception.RequestException;

public interface UserService {

    void save(UserRequest userRequest) throws RequestException;
    UserResponse findById(Long id);
    void update(UserRequest userRequest);
    UserResponse findByUsername(String username);

}
