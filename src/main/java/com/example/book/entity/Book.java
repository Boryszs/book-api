package com.example.book.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "published")
    private Integer published;

    @Column(name = "image")
    private String image;

    @Column(name = "available")
    private Boolean available;

    @ManyToMany(mappedBy = "books", cascade = { CascadeType.ALL })
    private List<Authors> authors;
}
