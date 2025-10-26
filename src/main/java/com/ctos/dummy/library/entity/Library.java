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
@Table(name = "library")
@NoArgsConstructor
@AllArgsConstructor

@NamedQuery(
        name = "Library.findByLibraryNameLike",
        query = "SELECT l FROM Library l WHERE l.libraryName LIKE CONCAT('%', :name, '%')"
)

public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "library_id")
    private Integer libraryId;

    @Column(name ="library_name", length = 100)
    private String libraryName;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("library")
    private List<Aisle> aisles;
}