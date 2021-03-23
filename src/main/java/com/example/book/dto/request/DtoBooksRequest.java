package com.example.book.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoBooksRequest {
    private String title;

    private String image;

    private Integer published;
}
