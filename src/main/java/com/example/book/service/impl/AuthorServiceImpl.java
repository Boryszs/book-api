package com.example.book.service.impl;

import com.example.book.dto.request.DtoAuthorRequest;
import com.example.book.dto.response.DtoAuthorResponse;
import com.example.book.entity.Authors;
import com.example.book.entity.Book;
import com.example.book.mapper.author.AuthorListMapper;
import com.example.book.mapper.author.AuthorMapper;
import com.example.book.mapper.book.BookMapper;
import com.example.book.repository.AuthorRespoitory;
import com.example.book.repository.BookRepository;
import com.example.book.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRespoitory authorRespoitory;
    private AuthorMapper authorMapper;
    private AuthorListMapper authorListMapper;
    private BookMapper bookMapper;
    private BookRepository bookRepository;

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

    @Override
    public void deleteById(Integer id) {
        authorRespoitory.deleteById(id);
    }

    @Override
    public void save(DtoAuthorRequest dtoAuthorRequest) {
        Book book = bookMapper.toBook(dtoAuthorRequest.getDtoBooksRequest());
        List<Authors> authors = authorMapper.toAuthor(dtoAuthorRequest.getDtoAuthorsRequest());

        for(Authors author:authors){
            if(authorRespoitory.existsByNameAndSurname(author.getName(),author.getSurname())) {
                Authors auth = authorRespoitory.findByNameAndSurname(author.getName(),author.getSurname());
                auth.getBooks().add(book);
                bookRepository.save(book);
                authorRespoitory.save(auth);
            }else{
                author.setBooks(new LinkedList<>(List.of(book)));
                bookRepository.save(book);
                author.setBooks(new LinkedList<>(List.of(book)));
                authorRespoitory.save(author);
            }
        }
    }
}
