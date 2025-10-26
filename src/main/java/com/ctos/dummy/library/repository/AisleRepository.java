package com.ctos.dummy.library.repository;

import com.ctos.dummy.library.entity.Aisle;
import com.ctos.dummy.library.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ishani.s
 */
@Repository
public interface AisleRepository extends JpaRepository<Aisle, Integer> {
    List<Aisle> findByLibrary(Library library);
    List<Aisle> findByLibrary_LibraryId(Integer libraryId);
}
