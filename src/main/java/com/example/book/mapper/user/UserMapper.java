package com.example.book.mapper.user;

import com.example.book.dto.request.UserRequest;
import com.example.book.dto.response.UserResponse;
import com.example.book.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private PasswordEncoder bcryptEncoder;

    @Autowired
    public UserMapper(PasswordEncoder bcryptEncoder) {
        this.bcryptEncoder = bcryptEncoder;
    }

    public UserResponse toUserRequest(User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setSurname(user.getSurname());
        userResponse.setEmail(user.getEmail());
        userResponse.setUsername(user.getUsername());
        return userResponse;
    }

    public User toUser(UserRequest userRequest){
        User user = new User();
        user.setName(userRequest.getName());
        user.setSurname(userRequest.getSurname());
        user.setPassword(bcryptEncoder.encode(userRequest.getPassword()));
        user.setEmail(userRequest.getEmail());
        user.setUsername(userRequest.getUsername());
        return user;
    }

}
