package com.example.book.mapper;

import com.example.book.dto.DtoAuthor;
import com.example.book.dto.DtoBooks;
import com.example.book.entity.Authors;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;


@Component
public class AuthorListMapper {

    public List<DtoAuthor> toDtoAuthor(List<Authors> authors){
        List<DtoAuthor> authorList = new LinkedList<>();

        authors.forEach(author -> {
            DtoAuthor dtoAuthor = new DtoAuthor();
            dtoAuthor.setId(author.getId());
            dtoAuthor.setName(author.getName());
            dtoAuthor.setSurname(author.getSurname());
            List<DtoBooks> bookList = new LinkedList<>();
            author.getBooks().forEach(book -> {
                DtoBooks dtoBook = new DtoBooks();
                dtoBook.setId(book.getId());
                dtoBook.setTitle(book.getTitle());
                dtoBook.setPublished(book.getPublished());
                dtoBook.setImage(book.getImage());
                bookList.add(dtoBook);
            });
            dtoAuthor.setBook(bookList);
            authorList.add(dtoAuthor);
        });
        return authorList;
    }

}
