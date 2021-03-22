package com.example.book.mapper;

import com.example.book.dto.DtoAuthors;
import com.example.book.entity.Authors;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public DtoAuthors toDtoAuthors(Authors authors){
        DtoAuthors dtoAuthors = new DtoAuthors();
        return dtoAuthors;
    }
}
