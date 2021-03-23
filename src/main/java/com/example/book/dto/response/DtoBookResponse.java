package com.example.book.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoBookResponse {

    private Integer id;

    private String title;

    private Integer published;

    private String image;

    private List<DtoAuthorsResponse> author;
}
