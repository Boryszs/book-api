package com.example.book.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoBooksRequest implements Serializable {

    private String title;
    private Integer published;
    private String image;
    private String description;
    private Boolean available;
}
