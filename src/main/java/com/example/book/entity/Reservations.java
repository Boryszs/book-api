package com.example.book.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservations")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Reservations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Integer id;

    @Column(name = "data_from")
    private Date dataFrom;

    @Column(name = "data_to")
    private Date dataTo;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;
}
