package com.ctos.dummy.library.controller;

import com.ctos.dummy.library.entity.Aisle;
import com.ctos.dummy.library.entity.Book;
import com.ctos.dummy.library.entity.Library;
import com.ctos.dummy.library.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ishani.s
 */
@RestController
@RequestMapping("/libraries")
@RequiredArgsConstructor
public class LibraryController {

    private final LibraryService libraryService;

    // get all books by aisle and library
    @GetMapping("/books")
    public List<Book> getBooksByLibraryAndAisle() {
        return libraryService.getBooksByLibraryAndAisleName("CENTRAL LIBRARY", "NATURAL HISTORY");
    }

    // save new library
    @PostMapping
    public Library saveLibrary(@RequestBody Library library) {
        return libraryService.saveLibrary(library);
    }

    // update library info
    @PutMapping("/{id}")
    public Library updateLibrary(@PathVariable Integer id, @RequestBody Library library) {
        return libraryService.updateLibrary(id, library);
    }

    // get all aisles of a library
    @GetMapping("/{id}/aisles")
    public List<Aisle> getAislesByLibrary(@PathVariable Integer id) {
        return libraryService.getAislesByLibraryId(id);
    }
}
