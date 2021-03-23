package com.example.book.mapper.author;

import com.example.book.dto.request.DtoAuthorsRequest;
import com.example.book.dto.response.DtoAuthorResponse;
import com.example.book.dto.response.DtoAuthorsResponse;
import com.example.book.dto.response.DtoBooksResponse;
import com.example.book.entity.Authors;
import com.example.book.entity.Book;
import com.example.book.service.AuthorService;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class AuthorMapper {

    public DtoAuthorResponse toDtoAuthors(Authors authors){
        DtoAuthorResponse dtoAuthorResponse = new DtoAuthorResponse();
        List<DtoBooksResponse> booksList = new LinkedList<>();

        dtoAuthorResponse.setId(authors.getId());
        dtoAuthorResponse.setName(authors.getName());
        dtoAuthorResponse.setSurname(authors.getSurname());


        for(Book book:authors.getBooks()){
            DtoBooksResponse dtoBooksResponse = new DtoBooksResponse();
            dtoBooksResponse.setId(book.getId());
            dtoBooksResponse.setTitle(book.getTitle());
            dtoBooksResponse.setPublished(book.getPublished());
            dtoBooksResponse.setImage(book.getImage());
            booksList.add(dtoBooksResponse);
        }
        dtoAuthorResponse.setBook(booksList);

        return dtoAuthorResponse;
    }

    public List<Authors> toAuthor(List<DtoAuthorsRequest> dtoAuthorsResponse){
        List<Authors> authorsList = new LinkedList<>();
        for(DtoAuthorsRequest authors:dtoAuthorsResponse){
            Authors author = new Authors();
            author.setName(authors.getName());
            author.setSurname(authors.getSurname());
            authorsList.add(author);
        }

        return authorsList;
    }

}
