package com.example.book.mapper;

import com.example.book.dto.DtoAuthors;
import com.example.book.dto.DtoBook;
import com.example.book.entity.Book;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class BookMapper {

   public DtoBook toDtoBook(Book book){
       List<DtoAuthors> authorList = new LinkedList<>();
       DtoBook dtoBook = new DtoBook();

       dtoBook.setId(book.getId());
       dtoBook.setTitle(book.getTitle());
       dtoBook.setPublished(book.getPublished());
       dtoBook.setImage(book.getImage());

       book.getAuthors().forEach(authors -> {
           DtoAuthors dtoAuthor = new DtoAuthors();
           dtoAuthor.setId(authors.getId());
           dtoAuthor.setName(authors.getName());
           dtoAuthor.setSurname(authors.getSurname());
           authorList.add(dtoAuthor);
       });
       dtoBook.setAuthor(authorList);

       return dtoBook;
   }
}
