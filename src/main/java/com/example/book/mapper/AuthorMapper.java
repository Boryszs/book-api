package com.example.book.mapper;

import com.example.book.dto.DtoAuthor;
import com.example.book.dto.DtoBooks;
import com.example.book.entity.Authors;
import com.example.book.entity.Book;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class AuthorMapper {

    public DtoAuthor toDtoAuthors(Authors authors){
        DtoAuthor dtoAuthor = new DtoAuthor();
        List<DtoBooks> booksList = new LinkedList<>();

        dtoAuthor.setId(authors.getId());
        dtoAuthor.setName(authors.getName());
        dtoAuthor.setSurname(authors.getSurname());


        for(Book book:authors.getBooks()){
            DtoBooks dtoBooks = new DtoBooks();
            dtoBooks.setId(book.getId());
            dtoBooks.setTitle(book.getTitle());
            dtoBooks.setPublished(book.getPublished());
            dtoBooks.setImage(book.getImage());
            booksList.add(dtoBooks);
        }
        dtoAuthor.setBook(booksList);

        return dtoAuthor;
    }
}
