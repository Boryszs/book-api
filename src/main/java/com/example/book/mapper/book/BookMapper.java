package com.example.book.mapper.book;

import com.example.book.dto.request.DtoBooksRequest;
import com.example.book.dto.response.DtoAuthorsResponse;
import com.example.book.dto.response.DtoBookResponse;
import com.example.book.entity.Book;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class BookMapper {

   public DtoBookResponse toDtoBook(Book book){
       List<DtoAuthorsResponse> authorList = new LinkedList<>();
       DtoBookResponse dtoBookResponse = new DtoBookResponse();

       dtoBookResponse.setId(book.getId());
       dtoBookResponse.setTitle(book.getTitle());
       dtoBookResponse.setPublished(book.getPublished());
       dtoBookResponse.setImage(book.getImage());

       book.getAuthors().forEach(authors -> {
           DtoAuthorsResponse dtoAuthor = new DtoAuthorsResponse();
           dtoAuthor.setId(authors.getId());
           dtoAuthor.setName(authors.getName());
           dtoAuthor.setSurname(authors.getSurname());
           authorList.add(dtoAuthor);
       });
       dtoBookResponse.setAuthor(authorList);

       return dtoBookResponse;
   }

    public Book toBook(DtoBooksRequest dtoBooksRequest){
       Book book = new Book();
       book.setImage(dtoBooksRequest.getImage());
       book.setTitle(dtoBooksRequest.getTitle());
       book.setPublished(dtoBooksRequest.getPublished());

       return book;
    }

}
