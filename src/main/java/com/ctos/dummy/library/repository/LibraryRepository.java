package com.ctos.dummy.library.repository;

import com.ctos.dummy.library.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author ishani.s
 */
public interface LibraryRepository extends JpaRepository<Library, Integer> {
    List<Library> findByLibraryNameLike(@Param("name") String name);
}
