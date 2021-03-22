package com.example.book.service.impl;

import com.example.book.dto.DtoAuthor;
import com.example.book.mapper.AuthorListMapper;
import com.example.book.mapper.AuthorMapper;
import com.example.book.repository.AuthorRespoitory;
import com.example.book.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRespoitory authorRespoitory;
    private AuthorMapper authorMapper;
    private AuthorListMapper authorListMapper;

    @Autowired
    public AuthorServiceImpl(AuthorRespoitory authorRespoitory, AuthorMapper authorMapper, AuthorListMapper authorListMapper) {
        this.authorRespoitory = authorRespoitory;
        this.authorMapper = authorMapper;
        this.authorListMapper = authorListMapper;
    }

    @Override
    public List<DtoAuthor> findAll() {
        return authorListMapper.toDtoAuthor(authorRespoitory.findAll());
    }

    @Override
    public DtoAuthor findById(Integer id) {
        return authorMapper.toDtoAuthors(authorRespoitory.findById(id).get());
    }

    @Override
    public void deleteById(Integer id) {
        authorRespoitory.deleteById(id);
    }
}
