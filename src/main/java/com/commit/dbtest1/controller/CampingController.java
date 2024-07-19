package com.commit.dbtest1.controller;

import com.commit.dbtest1.entity.Camping;
import com.commit.dbtest1.service.CampingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/campings")
public class CampingController {
    private final CampingService campingService;

    @Autowired
    public CampingController(CampingService campingService) {
        this.campingService = campingService;
    }

    @PostMapping
    public Camping createCamping(@RequestBody Camping camping) {
        return campingService.saveCamping(camping);
    }

    @GetMapping("/{campId}")
    public Camping getCamping(@PathVariable Long campId) {
        return campingService.getCamping(campId).orElseThrow(() -> new RuntimeException("Camping not found"));
    }
}
