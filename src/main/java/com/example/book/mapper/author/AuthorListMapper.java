package com.example.book.mapper.author;

import com.example.book.dto.response.DtoAuthorResponse;
import com.example.book.dto.response.DtoBooksResponse;
import com.example.book.entity.Authors;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;


@Component
public class AuthorListMapper {

    public List<DtoAuthorResponse> toDtoAuthor(List<Authors> authors){
        List<DtoAuthorResponse> authorList = new LinkedList<>();

        authors.forEach(author -> {
            DtoAuthorResponse dtoAuthorResponse = new DtoAuthorResponse();
            dtoAuthorResponse.setId(author.getId());
            dtoAuthorResponse.setName(author.getName());
            dtoAuthorResponse.setSurname(author.getSurname());
            List<DtoBooksResponse> bookList = new LinkedList<>();
            author.getBooks().forEach(book -> {
                DtoBooksResponse dtoBook = new DtoBooksResponse();
                dtoBook.setId(book.getId());
                dtoBook.setTitle(book.getTitle());
                dtoBook.setPublished(book.getPublished());
                dtoBook.setImage(book.getImage());
                dtoBook.setAvailable(book.getAvailable());
                bookList.add(dtoBook);
            });
            dtoAuthorResponse.setBook(bookList);
            authorList.add(dtoAuthorResponse);
        });
        return authorList;
    }

}
