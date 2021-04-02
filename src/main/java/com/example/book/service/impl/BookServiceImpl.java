package com.example.book.service.impl;

import com.example.book.dto.request.DtoBookRequest;
import com.example.book.dto.request.DtoBooksRequest;
import com.example.book.dto.response.DtoBookResponse;
import com.example.book.entity.Authors;
import com.example.book.entity.Book;
import com.example.book.mapper.author.AuthorMapper;
import com.example.book.mapper.book.BookListMapper;
import com.example.book.mapper.book.BookMapper;
import com.example.book.repository.AuthorRespoitory;
import com.example.book.repository.BookRepository;
import com.example.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private BookListMapper bookListMapper;
    private BookMapper bookMapper;
    private AuthorMapper authorMapper;
    private AuthorRespoitory authorRespoitory;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookListMapper bookListMapper, BookMapper bookMapper, AuthorMapper authorMapper, AuthorRespoitory authorRespoitory) {
        this.bookRepository = bookRepository;
        this.bookListMapper = bookListMapper;
        this.bookMapper = bookMapper;
        this.authorMapper = authorMapper;
        this.authorRespoitory = authorRespoitory;
    }

    @Override
    public List<DtoBookResponse> findAll() {
        return bookListMapper.toDtoBook(bookRepository.findAll());
    }

    @Override
    public DtoBookResponse findById(Integer id) {
        return bookMapper.toDtoBook(bookRepository.findById(id).get());
    }

    @Override
    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void save(DtoBookRequest dtoBookRequest) {
        Book book = bookMapper.toBook(dtoBookRequest.getDtoBooksRequest());
        List<Authors> authors = authorMapper.toAuthor(dtoBookRequest.getDtoAuthorsRequest());

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
    public void update(Integer id, DtoBooksRequest dtoBooksRequest) {
       Optional<Book> book = bookRepository.findById(id);
       if(book.isPresent()){
           book.get().setImage(dtoBooksRequest.getImage());
           book.get().setTitle(dtoBooksRequest.getTitle());
           book.get().setPublished(dtoBooksRequest.getPublished());
           bookRepository.save(book.get());
       }
    }


}
