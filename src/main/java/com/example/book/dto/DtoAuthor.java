package com.example.book.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoAuthor {

    private Integer id;

    private String name;

    private String surname;

    private List<DtoBook> book;
}
