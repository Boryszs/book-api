package com.example.book.service;

import com.example.book.dto.request.DtoReservationRequest;
import com.example.book.dto.response.DtoReservationsResponse;

import java.util.Date;
import java.util.List;

public interface ReservationService {

    List<DtoReservationsResponse> findAll(Long id);

    void save(DtoReservationRequest reservations);

    void deleteById(Integer id);

    void update(DtoReservationRequest reservations, Integer id);
}
