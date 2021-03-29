package com.example.book.controller;

import com.example.book.dto.request.DtoBookRequest;
import com.example.book.dto.request.DtoReservationRequest;
import com.example.book.dto.response.DtoReservationsResponse;
import com.example.book.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/reservation")
public class ReservationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);
    private ReservationService reservationService;


    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public void saveReservation(@RequestBody DtoReservationRequest dtoReservationRequest){
        LOGGER.info("ADD RESERVATION"+dtoReservationRequest);
        reservationService.save(dtoReservationRequest);
    }


    @GetMapping("/{id}")
    public List<DtoReservationsResponse> getReservation(@PathVariable(value = "id") Long id){
        LOGGER.info("GET RESERVATION");
        return reservationService.findAll(id,new Date());
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable(value = "id") Integer id){
        LOGGER.info("DELETE RESERVATION");
        reservationService.deleteById(id);
    }

}
