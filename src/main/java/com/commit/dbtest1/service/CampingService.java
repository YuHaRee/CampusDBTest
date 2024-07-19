package com.commit.dbtest1.service;

import com.commit.dbtest1.entity.Camping;
import com.commit.dbtest1.repository.CampingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CampingService {
    private final CampingRepository campingRepository;

    @Autowired
    public CampingService(CampingRepository campingRepository) {
        this.campingRepository = campingRepository;
    }

    public Camping saveCamping(Camping camping) {
        return campingRepository.save(camping);
    }

    public Optional<Camping> getCamping(Long campId) {
        return campingRepository.findById(campId);
    }
    
}
