package com.example.book.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoAuthorResponse implements Serializable {

    private Integer id;

    private String name;

    private String surname;

    private List<DtoBooksResponse> book;
}
