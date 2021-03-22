package com.example.book.mapper;

import com.example.book.dto.DtoAuthor;
import com.example.book.dto.DtoBook;
import com.example.book.entity.Authors;
import com.example.book.entity.Book;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;


@Component
public class AuthorListMapper {

    public DtoAuthor toDtoAuthor(Authors authors){
        DtoAuthor dtoAuthor = new DtoAuthor();
        List<DtoBook> bookList = new LinkedList<>();

        dtoAuthor.setId(authors.getId());
        dtoAuthor.setName(authors.getName());
        dtoAuthor.setSurname(authors.getSurname());

        for (Book book: authors.getBooks()){
            DtoBook dtoBook = new DtoBook();
            dtoBook.setId(book.getId());
            dtoBook.setTitle(book.getTitle());
            dtoBook.setPublished(book.getPublished());
            bookList.add(dtoBook);
        }

        return dtoAuthor;
    }

}
