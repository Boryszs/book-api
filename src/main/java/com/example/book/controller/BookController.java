package com.example.book.controller;

import com.example.book.dto.DtoBook;
import com.example.book.dto.DtoBooks;
import com.example.book.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/book")
public class BookController {

    private BookService bookService;
    private static  final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<DtoBook>> getAllBook(){
        LOGGER.info("GET ALL BOOKS");
        return new ResponseEntity(bookService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DtoBook> getBook(@RequestParam(value = "title", required = false) String title){
        LOGGER.info("GET BOOK TITLE ",title);
        return new ResponseEntity(bookService.findByTitle(title), HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteBook(@RequestParam(value = "id", required = false) Integer id){
        LOGGER.info("DELETE BOOK ID ", id);
        bookService.deleteById(id);
    }

    @PutMapping
    public void updateBook(@RequestParam(value = "id", required = false) Integer id, @RequestBody DtoBooks dtoBooks){

    }

    @PostMapping
    public void saveBook(@RequestBody DtoBook dtoBook){
        
    }

}
