package com.ctos.dummy.library.dto;

import java.util.List;

/**
 * @author ishani.s
 */
public record LibraryDto(
        Integer libraryId,
        String libraryName,
        List<AisleDto> aisles
) {}
