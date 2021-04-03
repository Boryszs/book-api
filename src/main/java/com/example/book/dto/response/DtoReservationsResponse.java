package com.example.book.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoReservationsResponse implements Serializable {

    private String dataFrom;
    private String dataTo;
    private DtoBookResponse book;
}
