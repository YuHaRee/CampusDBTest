package com.commit.dbtest1.service;

import com.commit.dbtest1.dto.CampingDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CampingService {
    Optional<CampingDTO> findById(Long campId);
    List<CampingDTO> getCampingsWithCursor(CampingDTO filter, LocalDateTime cursor, int limit);
}
