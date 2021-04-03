package com.example.book.repository;

import com.example.book.entity.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservations, Integer> {

    @Query("SELECT r FROM Reservations r WHERE r.user.id= ?1 and r.dataTo >= ?2")
    List<Reservations> findAll(Long id, Date date);
}
