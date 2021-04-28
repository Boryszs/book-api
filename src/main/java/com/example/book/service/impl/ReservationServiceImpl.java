package com.example.book.service.impl;

import com.example.book.dto.request.DtoReservationRequest;
import com.example.book.dto.response.DtoReservationsResponse;
import com.example.book.entity.Book;
import com.example.book.entity.Reservations;
import com.example.book.mapper.reservation.ReservationListMapper;
import com.example.book.mapper.reservation.ReservationMapper;
import com.example.book.repository.BookRepository;
import com.example.book.repository.ReservationRepository;
import com.example.book.repository.UserRepository;
import com.example.book.service.ReservationService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Log
public class ReservationServiceImpl implements ReservationService {

    private final ReservationListMapper reservationListMapper;
    private final ReservationMapper reservationMapper;
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Autowired
    public ReservationServiceImpl(ReservationListMapper reservationListMapper, ReservationMapper reservationMapper, ReservationRepository reservationRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.reservationListMapper = reservationListMapper;
        this.reservationMapper = reservationMapper;
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<DtoReservationsResponse> findAll(Long id) {
        return reservationListMapper.todtoReservationsResponse(reservationRepository.findAll(id));
    }

    @Override
    public void save(DtoReservationRequest reservations) {
        Reservations reservation = reservationMapper.toReservations(reservations);
        Book book = bookRepository.findById(reservations.getBookId()).get();
        book.setAvailable(false);
        bookRepository.save(book);
        reservation.setBook(book);
        reservation.setUser(userRepository.findById(reservations.getUserId()).get());
        reservationRepository.save(reservation);
    }

    @Transactional
    @Modifying
    @Override
    public void deleteById(Integer id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public void update(DtoReservationRequest reservations, Integer id) {
        Reservations reservation = reservationMapper.toReservations(reservations);
        reservation.setBook(bookRepository.findById(reservations.getBookId()).get());
        reservation.setUser(userRepository.findById(reservations.getUserId()).get());
        reservation.setId(id);
        reservationRepository.save(reservation);
    }

}
