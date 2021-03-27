package com.example.book.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoBookResponse implements Serializable {

    private Integer id;

    private String title;

    private Integer published;

    private String image;

    private String description;

    private Boolean available;

    private List<DtoAuthorsResponse> author;
}
