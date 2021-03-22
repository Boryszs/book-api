package com.example.book.service;

import com.example.book.dto.DtoBook;

import java.util.List;

public interface BookService {
    List<DtoBook> findAll();
    DtoBook findById(Integer name);
    void deleteById(Integer id);
}
