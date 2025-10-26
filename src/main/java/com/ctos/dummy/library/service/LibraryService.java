package com.ctos.dummy.library.service;

import com.ctos.dummy.library.entity.Aisle;
import com.ctos.dummy.library.entity.Book;
import com.ctos.dummy.library.entity.Library;
import com.ctos.dummy.library.repository.AisleRepository;
import com.ctos.dummy.library.repository.BookRepository;
import com.ctos.dummy.library.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ishani.s
 */
@Service
public class LibraryService {
    private final AisleRepository aisleRepository;
    private final LibraryRepository libraryRepository;
    private final BookRepository bookRepository;

    public LibraryService(AisleRepository aisleRepository, LibraryRepository libraryRepository, BookRepository bookRepository) {
        this.aisleRepository = aisleRepository;
        this.libraryRepository = libraryRepository;
        this.bookRepository = bookRepository;
    }

    // get all aisles by library id
    public List<Aisle> getAislesByLibraryId(Integer libraryId) {
        return aisleRepository.findByLibrary_LibraryId(libraryId);
    }

    // save new library
    public Library saveLibrary(Library library) {
        return libraryRepository.save(library);
    }

    // update library
    public Library updateLibrary(Integer id, Library libraryDetails) {
        Library library = libraryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Library not found"));
        library.setLibraryName(libraryDetails.getLibraryName());
        return libraryRepository.save(library);
    }

    // get all books by aisle ID
    public List<Book> getBooksByAisleId(Integer aisleId) {
        return bookRepository.findByAisles_AisleId(aisleId);
    }

    // get books by library and aisle name
    public List<Book> getBooksByLibraryAndAisleName(String libraryName, String aisleName) {
        return libraryRepository.findByLibraryNameLike(libraryName).stream()
                .flatMap(library -> library.getAisles().stream())
                .filter(a -> a.getAisleName().equalsIgnoreCase(aisleName))
                .flatMap(a -> a.getBooks().stream())
                .toList();
    }
}
