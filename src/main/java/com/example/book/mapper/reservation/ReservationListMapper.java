package com.example.book.mapper.reservation;

import com.example.book.dto.response.DtoReservationsResponse;
import com.example.book.entity.Reservations;
import com.example.book.mapper.book.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Component
public class ReservationListMapper {

    private BookMapper bookMapper;

    @Autowired
    public ReservationListMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public List<DtoReservationsResponse> todtoReservationsResponse(List<Reservations> reservationsList) {
        List<DtoReservationsResponse> responseList = new LinkedList<>();

        reservationsList.forEach(reservations -> {
            DtoReservationsResponse reservationsResponse = new DtoReservationsResponse();
            reservationsResponse.setDataTo(new SimpleDateFormat("dd-MM-yyyy").format(reservations.getDataTo()));
            reservationsResponse.setDataFrom(new SimpleDateFormat("dd-MM-yyyy").format(reservations.getDataFrom()));
            reservationsResponse.setBook(bookMapper.toDtoBook(reservations.getBook()));
            responseList.add(reservationsResponse);
        });

        return responseList;
    }
}
