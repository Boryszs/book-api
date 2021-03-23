package com.example.book.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoBooksResponse {

    private Integer id;

    private String title;

    private String image;

    private Integer published;
}
