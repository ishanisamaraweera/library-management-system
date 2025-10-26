package com.ctos.dummy.library;

import com.ctos.dummy.library.controller.LibraryController;
import com.ctos.dummy.library.entity.Aisle;
import com.ctos.dummy.library.entity.Book;
import com.ctos.dummy.library.entity.Library;
import com.ctos.dummy.library.service.LibraryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LibraryControllerTest {

    @Mock
    private LibraryService libraryService;  // regular Mockito mock

    @InjectMocks
    private LibraryController libraryController;  // injects mock into controller

    private Library library1;
    private Library library2;

    @BeforeEach
    void setUp() {
        library1 = new Library();
        library1.setLibraryId(1);
        library1.setLibraryName("Central Library");

        library2 = new Library();
        library2.setLibraryId(2);
        library2.setLibraryName("City Library");
    }

    @Test
    void testSaveLibrary() {
        when(libraryService.saveLibrary(library1)).thenReturn(library1);

        Library saved = libraryController.saveLibrary(library1);
        assertNotNull(saved);
        assertEquals("Central Library", saved.getLibraryName());

        verify(libraryService, times(1)).saveLibrary(library1);
    }

    @Test
    void testUpdateLibrary() {
        Library updatedLibrary = new Library();
        updatedLibrary.setLibraryId(1);
        updatedLibrary.setLibraryName("Updated Library");

        when(libraryService.updateLibrary(1, updatedLibrary)).thenReturn(updatedLibrary);

        Library updated = libraryController.updateLibrary(1, updatedLibrary);
        assertNotNull(updated);
        assertEquals("Updated Library", updated.getLibraryName());

        verify(libraryService, times(1)).updateLibrary(1, updatedLibrary);
    }

    @Test
    void testGetAislesByLibrary() {
        Aisle aisle1 = new Aisle();
        aisle1.setAisleId(1);
        aisle1.setAisleName("Natural History");

        Aisle aisle2 = new Aisle();
        aisle2.setAisleId(2);
        aisle2.setAisleName("Science");

        List<Aisle> aisles = Arrays.asList(aisle1, aisle2);
        when(libraryService.getAislesByLibraryId(1)).thenReturn(aisles);

        List<Aisle> result = libraryController.getAislesByLibrary(1);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Natural History", result.get(0).getAisleName());

        verify(libraryService, times(1)).getAislesByLibraryId(1);
    }

    @Test
    void testGetBooksByLibraryAndAisle() {
        Book book1 = new Book();
        book1.setBookId(1);
        book1.setBookName("Book A");

        Book book2 = new Book();
        book2.setBookId(2);
        book2.setBookName("Book B");

        List<Book> books = Arrays.asList(book1, book2);
        when(libraryService.getBooksByLibraryAndAisleName("CENTRAL LIBRARY", "NATURAL HISTORY"))
                .thenReturn(books);

        List<Book> result = libraryController.getBooksByLibraryAndAisle();
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Book A", result.get(0).getBookName());

        verify(libraryService, times(1))
                .getBooksByLibraryAndAisleName("CENTRAL LIBRARY", "NATURAL HISTORY");
    }
}
