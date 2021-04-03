package com.example.book.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoAuthorsResponse implements Serializable {

    private Integer id;
    private String name;
    private String surname;

}
