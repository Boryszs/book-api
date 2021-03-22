package com.example.book.service.impl;

import com.example.book.dto.DtoBook;
import com.example.book.mapper.BookListMapper;
import com.example.book.mapper.BookMapper;
import com.example.book.repository.BookRepository;
import com.example.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private BookListMapper bookListMapper;
    private BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookListMapper bookListMapper, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookListMapper = bookListMapper;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<DtoBook> findAll() {
        return bookListMapper.toDtoBook(bookRepository.findAll());
    }

    @Override
    public DtoBook findById(Integer id) {
        return bookMapper.toDtoBook(bookRepository.findById(id).get());
    }

    @Override
    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }
}
