package com.example.book.repository;

import com.example.book.entity.Authors;
import com.example.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<List<Book>> findByAuthors(Authors authors);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Book b set b.available = :available WHERE b.id = (SELECT r.book.id FROM Reservations r WHERE r.dataTo < CURRENT_DATE)")
    void checkAvailable(@Param("available") Boolean available);

}
