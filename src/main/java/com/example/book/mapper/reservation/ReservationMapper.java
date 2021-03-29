package com.example.book.mapper.reservation;

import com.example.book.dto.request.DtoReservationRequest;
import com.example.book.dto.response.DtoReservationsResponse;
import com.example.book.entity.Reservations;
import com.example.book.mapper.book.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    private BookMapper bookMapper;

    @Autowired
    public ReservationMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public Reservations toReservations(DtoReservationRequest dtoReservationRequest){
        Reservations reservations = new Reservations();
        reservations.setDataFrom(dtoReservationRequest.getDataFrom());
        reservations.setDataTo(dtoReservationRequest.getDataTo());
        return reservations;
    }


    public DtoReservationsResponse toDtoReservation(Reservations reservations){
        DtoReservationsResponse dtoReservationsResponse = new DtoReservationsResponse();
        dtoReservationsResponse.setDataFrom(reservations.getDataFrom());
        dtoReservationsResponse.setDataTo(reservations.getDataTo());
        dtoReservationsResponse.setBook(bookMapper.toDtoBook(reservations.getBook()));
        return dtoReservationsResponse;
    }

}
