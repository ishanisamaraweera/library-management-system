package com.ctos.dummy.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 *
 @author ishani.s
 */
@Entity
@Getter
@Setter
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", length = 20)
    private Integer bookId;

    @Column(name ="book_name", length = 45)
    private String bookName;

    @ManyToMany(mappedBy = "books")
    @JsonIgnoreProperties("books")
    private List<Aisle> aisles;
}
