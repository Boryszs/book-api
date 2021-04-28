package com.example.book.service.impl;

import com.example.book.dto.request.DtoAuthorRequest;
import com.example.book.dto.request.DtoAuthorsRequest;
import com.example.book.dto.response.DtoAuthorResponse;
import com.example.book.entity.Authors;
import com.example.book.entity.Book;
import com.example.book.mapper.author.AuthorListMapper;
import com.example.book.mapper.author.AuthorMapper;
import com.example.book.mapper.book.BookMapper;
import com.example.book.repository.AuthorRespoitory;
import com.example.book.repository.BookRepository;
import com.example.book.service.AuthorService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Log
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRespoitory authorRespoitory;
    private final AuthorMapper authorMapper;
    private final AuthorListMapper authorListMapper;
    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRespoitory authorRespoitory, AuthorMapper authorMapper, AuthorListMapper authorListMapper, BookMapper bookMapper, BookRepository bookRepository) {
        this.authorRespoitory = authorRespoitory;
        this.authorMapper = authorMapper;
        this.authorListMapper = authorListMapper;
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<DtoAuthorResponse> findAll() {
        return authorListMapper.toDtoAuthor(authorRespoitory.findAll());
    }

    @Override
    public DtoAuthorResponse findById(Integer id) {
        return authorMapper.toDtoAuthors(authorRespoitory.findById(id).get());
    }

    @Transactional
    @Modifying
    @Override
    public void deleteById(Integer id) {
        authorRespoitory.deleteById(id);
    }

    @Override
    public void save(DtoAuthorRequest dtoAuthorRequest) {
        Book book = bookMapper.toBook(dtoAuthorRequest.getDtoBooksRequest());
        List<Authors> authors = authorMapper.toAuthor(dtoAuthorRequest.getDtoAuthorsRequest());

        authors.forEach(author -> {
            if (authorRespoitory.existsByNameAndSurname(author.getName(), author.getSurname())) {
                Authors auth = authorRespoitory.findByNameAndSurname(author.getName(), author.getSurname());
                auth.getBooks().add(book);
                bookRepository.save(book);
                authorRespoitory.save(auth);
            } else {
                author.setBooks(new LinkedList<>(List.of(book)));
                bookRepository.save(book);
                author.setBooks(new LinkedList<>(List.of(book)));
                authorRespoitory.save(author);
            }
        });
    }

    @Override
    public void update(Integer id, DtoAuthorsRequest dtoAuthorsRequest) {
        Optional<Authors> authors = authorRespoitory.findById(id);
        if (authors.isPresent()) {
            authors.get().setName(dtoAuthorsRequest.getName());
            authors.get().setSurname(dtoAuthorsRequest.getSurname());
            authors.get().setBooks(authors.get().getBooks());
            authorRespoitory.save(authors.get());
        }
    }
}
