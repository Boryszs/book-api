package com.example.book.service;

import com.example.book.dto.request.DtoAuthorRequest;
import com.example.book.dto.request.DtoAuthorsRequest;
import com.example.book.dto.response.DtoAuthorResponse;

import java.util.List;

public interface AuthorService {
    List<DtoAuthorResponse> findAll();

    DtoAuthorResponse findById(Integer id);

    void deleteById(Integer id);

    void save(DtoAuthorRequest dtoAuthorRequest);

    void update(Integer id, DtoAuthorsRequest dtoAuthorsRequest);
}