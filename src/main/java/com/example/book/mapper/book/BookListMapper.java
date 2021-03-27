package com.example.book.mapper.book;

import com.example.book.dto.response.DtoAuthorsResponse;
import com.example.book.dto.response.DtoBookResponse;
import com.example.book.entity.Book;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class BookListMapper {

   public List<DtoBookResponse> toDtoBook(List<Book> books){
       List<DtoBookResponse> bookList = new LinkedList<>();

       books.forEach(book -> {
           DtoBookResponse dtoBookResponse = new DtoBookResponse();
           dtoBookResponse.setId(book.getId());
           dtoBookResponse.setTitle(book.getTitle());
           dtoBookResponse.setPublished(book.getPublished());
           dtoBookResponse.setImage(book.getImage());
           dtoBookResponse.setAvailable(book.getAvailable());
           List<DtoAuthorsResponse> authorList = new LinkedList<>();
           book.getAuthors().forEach(authors -> {
               DtoAuthorsResponse dtoAuthorsResponse = new DtoAuthorsResponse();
               dtoAuthorsResponse.setId(authors.getId());
               dtoAuthorsResponse.setName(authors.getName());
               dtoAuthorsResponse.setSurname(authors.getSurname());
               authorList.add(dtoAuthorsResponse);
           });
           dtoBookResponse.setAuthor(authorList);
           bookList.add(dtoBookResponse);
       });
       return bookList;
   }
}
