package com.example.book.mapper;

import com.example.book.dto.DtoAuthors;
import com.example.book.dto.DtoBook;
import com.example.book.entity.Book;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class BookListMapper {

   public List<DtoBook> toDtoBook(List<Book> books){
       List<DtoBook> bookList = new LinkedList<>();

       books.forEach(book -> {
           DtoBook dtoBook = new DtoBook();
           dtoBook.setId(book.getId());
           dtoBook.setTitle(book.getTitle());
           dtoBook.setPublished(book.getPublished());
           List<DtoAuthors> authorList = new LinkedList<>();
           book.getAuthors().forEach(authors -> {
               DtoAuthors dtoAuthors = new DtoAuthors();
               dtoAuthors.setId(authors.getId());
               dtoAuthors.setName(authors.getName());
               dtoAuthors.setSurname(authors.getSurname());
               authorList.add(dtoAuthors);
           });
           dtoBook.setAuthor(authorList);
           bookList.add(dtoBook);
       });
       return bookList;
   }
}
