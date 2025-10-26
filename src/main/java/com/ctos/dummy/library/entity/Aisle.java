
package com.ctos.dummy.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * @author ishani.s
 */
@Entity
@Getter
@Setter
@Table(name = "aisle")
@NoArgsConstructor
@AllArgsConstructor
public class Aisle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aisle_id")
    private Integer aisleId;

    @Column(name = "aisle_name", length = 45)
    private String aisleName;

    // Many aisles belong to one library
    @ManyToOne
    @JoinColumn(name = "library_id")
    @JsonIgnoreProperties("aisles")
    private Library library;

    // Many-to-many with Book
    @ManyToMany
    @JoinTable(
            name = "aisle_book",
            joinColumns = @JoinColumn(name = "aisle_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books;
}