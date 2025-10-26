package com.ctos.dummy.library.repository;

import com.ctos.dummy.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ishani.s
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("SELECT b FROM Book b JOIN b.aisles a WHERE a.aisleId = :aisleId")
    List<Book> findBooksByAisleId(@Param("aisleId") Integer aisleId);

    List<Book> findByAisles_AisleId(Integer aisleId);
}
