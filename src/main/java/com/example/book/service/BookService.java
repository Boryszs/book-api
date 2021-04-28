package com.example.book.service;

import com.example.book.dto.request.DtoBookRequest;
import com.example.book.dto.request.DtoBooksRequest;
import com.example.book.dto.response.DtoBookResponse;

import java.util.List;

public interface BookService {
    List<DtoBookResponse> findAll();

    List<DtoBookResponse> findAllPagination(Integer pageNo, Integer pageSize);

    DtoBookResponse findById(Integer name);

    void deleteById(Integer id);

    long count();

    void save(DtoBookRequest dtoBookRequest);

    void update(Integer id, DtoBooksRequest dtoBooksRequest);
}
