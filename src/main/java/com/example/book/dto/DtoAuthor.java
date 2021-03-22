package com.example.book.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoAuthor {

    private Integer id;

    private String name;

    private String surname;

    private List<DtoBooks> book;
}
