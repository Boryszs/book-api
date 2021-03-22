package com.example.book.controller;


import com.example.book.dto.DtoBook;
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
    public ResponseEntity<List<DtoBook>> getAllBook(){
        LOGGER.info("GET ALL AUTHORS");
        return new ResponseEntity(authorService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<DtoBook>> getAuthor(@PathVariable(value = "id") Integer id){
        LOGGER.info("GET AUTHORS ID ",id);
        return new ResponseEntity(authorService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable(value = "id") Integer id){
        LOGGER.info("DELETE AUTHORS ID ",id);
        authorService.deleteById(id);
    }
}
