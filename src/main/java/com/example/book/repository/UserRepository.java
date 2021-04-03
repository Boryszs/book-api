package com.example.book.repository;

import com.example.book.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

    boolean existsByNameOrEmail(String name, String email);
}
