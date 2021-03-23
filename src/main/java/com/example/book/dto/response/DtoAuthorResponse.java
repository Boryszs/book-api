package com.example.book.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoAuthorResponse {

    private Integer id;

    private String name;

    private String surname;

    private List<DtoBooksResponse> book;
}
