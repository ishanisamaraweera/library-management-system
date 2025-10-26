package com.ctos.dummy.library.controller;

import com.ctos.dummy.library.dto.AisleDto;
import com.ctos.dummy.library.service.LibraryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ishani.s
 */
@RestController
@RequestMapping("/library")
public class AisleController {
    private final LibraryService libraryService;

    public AisleController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/{id}/aisles")
    public List<AisleDto> getAislesByLibrary(@PathVariable Integer id) {
        // Convert entity to DTO
        return libraryService.getAislesByLibraryId(id)
                .stream()
                .map(a -> new AisleDto(a.getAisleId(), a.getAisleName()))
                .toList();
    }
}
