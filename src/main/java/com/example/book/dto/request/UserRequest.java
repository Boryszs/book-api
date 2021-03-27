package com.example.book.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest implements Serializable {
    private String username;
    private String name;
    private String surname;
    private String password;
    private String email;
}
