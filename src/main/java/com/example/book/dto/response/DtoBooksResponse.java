package com.example.book.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoBooksResponse implements Serializable {

    private Integer id;
    private String title;
    private Integer published;
    private String image;
    private String description;
    private Boolean available;
}
