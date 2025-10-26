package com.ctos.dummy.library.Dto;

import java.util.List;

/**
 * @author ishani.s
 */
public record LibraryDto(
        Integer libraryId,
        String libraryName,
        List<AisleDto> aisles
) {}
