package com.example.book.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthenticationResponse implements Serializable {

    private Long id;
    @JsonProperty(value = "jwt_token")
    private String jwtToken;
}
