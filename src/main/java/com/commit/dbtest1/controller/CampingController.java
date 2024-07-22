package com.commit.dbtest1.controller;

import com.commit.dbtest1.entity.Camping;
import com.commit.dbtest1.service.CampingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/campings")
public class CampingController {
    private final CampingService campingService;

    @Autowired
    public CampingController(CampingService campingService) {
        this.campingService = campingService;
    }

    @GetMapping("/{campId}")
    public Camping getCamping(@PathVariable Long campId) {
        return campingService.findById(campId).orElseThrow(() -> new RuntimeException("Camping not found"));
    }

    @GetMapping
    public List<Camping> filterCamping(@RequestParam(required = false) String doName,
                                       @RequestParam(required = false) String sigunguName) {
        return campingService.filterByAttributes(doName, sigunguName);
    }
}

