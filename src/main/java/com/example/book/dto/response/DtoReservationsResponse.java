package com.example.book.dto.response;

import com.example.book.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoReservationsResponse {

    private Date dataFrom;
    private Date dataTo;
    private DtoBookResponse book;
}
