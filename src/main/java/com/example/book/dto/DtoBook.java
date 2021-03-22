package com.example.book.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoBook {

    private Integer id;

    private String title;

    private Integer published;

    private String image;

    private List<DtoAuthors> author;
}
