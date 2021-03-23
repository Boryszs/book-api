package com.example.book.service;

import com.example.book.dto.request.DtoAuthorRequest;
import com.example.book.dto.response.DtoAuthorResponse;
import com.example.book.entity.Authors;

import java.util.List;

public interface AuthorService {
    List<DtoAuthorResponse> findAll();
    DtoAuthorResponse findById(Integer id);
    void deleteById(Integer id);
    void save(DtoAuthorRequest dtoAuthorRequest);
}
