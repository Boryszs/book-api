package com.example.book.service.impl;

import com.example.book.service.BookService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
class BookServiceImplTest {

    @Autowired
    private BookService bookService;


    @Transactional
    @DisplayName("Test Time Book Get All")
    @Test
    @Timeout(value = 1)
    void findAll() {
        bookService.findAll();
    }

    @Test
    void findById() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }
}