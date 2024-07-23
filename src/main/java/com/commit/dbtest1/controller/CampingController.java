package com.commit.dbtest1.controller;

import com.commit.dbtest1.dto.CampingDTO;
import com.commit.dbtest1.service.CampingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/campings")
public class CampingController {
    private final CampingService campingService;

    @Autowired
    public CampingController(CampingService campingService) {
        this.campingService = campingService;
    }

    @GetMapping
    public ResponseEntity<List<CampingDTO>> getCampings(CampingDTO filter,
                                                        @RequestParam(required = false) LocalDateTime cursor,
                                                        @RequestParam(defaultValue = "10") int limit) {
        if (cursor == null) {
            cursor = LocalDateTime.MIN;
        }

        List<CampingDTO> campings = campingService.getCampingsWithCursor(filter, cursor, limit);

        return ResponseEntity.ok(campings);
    }
}
