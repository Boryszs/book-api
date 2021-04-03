package com.example.book.repository;

import com.example.book.entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRespoitory extends JpaRepository<Authors, Integer> {
    boolean existsByNameAndSurname(String name, String surname);

    Authors findByNameAndSurname(String name, String surname);
}
