package com.example.book.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "book")
public class Book implements Serializable {

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

    @Lob
    @Column(name = "description", length = 100000)
    private String description;

    @Column(name = "available")
    private Boolean available;

    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)
    private List<Authors> authors;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Reservations> reservations;
}
