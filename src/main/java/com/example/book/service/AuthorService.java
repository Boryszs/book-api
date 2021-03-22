package com.example.book.service;

import com.example.book.dto.DtoAuthor;

import java.util.List;

public interface AuthorService {
    List<DtoAuthor> findAll();
    DtoAuthor findById(Integer id);
    void deleteById(Integer id);
}
