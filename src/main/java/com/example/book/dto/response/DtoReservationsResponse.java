package com.example.book.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoReservationsResponse implements Serializable {

    private Date dataFrom;
    private Date dataTo;
    private DtoBookResponse book;
}
