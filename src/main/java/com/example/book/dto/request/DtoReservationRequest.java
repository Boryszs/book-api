package com.example.book.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoReservationRequest {

    private Long userId;
    private Date dataFrom;
    private Date dataTo;
    private Integer bookId;
}
