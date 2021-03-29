package com.example.book.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse implements Serializable {
    private Long id;
    private String username;
    private String name;
    private String surname;
    private String email;
}
