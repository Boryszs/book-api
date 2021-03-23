package com.example.book.controller;


import com.example.book.dto.request.DtoAuthorRequest;
import com.example.book.dto.request.DtoAuthorsRequest;
import com.example.book.dto.response.DtoBookResponse;
import com.example.book.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/author")
public class AuthorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorController.class);
    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<DtoBookResponse>> getAllBook(){
        LOGGER.info("GET ALL AUTHORS");
        return new ResponseEntity(authorService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<DtoBookResponse>> getAuthor(@PathVariable(value = "id") Integer id){
        LOGGER.info("GET AUTHOR ID ",id);
        return new ResponseEntity(authorService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable(value = "id") Integer id){
        LOGGER.info("DELETE AUTHOR ID ",id);
        authorService.deleteById(id);
    }

    @PostMapping
    public void addAuthor(@RequestBody DtoAuthorRequest authorRequest){
        LOGGER.info("ADD AUTHOR");
        authorService.save(authorRequest);
    }
}
