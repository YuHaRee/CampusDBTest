package com.commit.dbtest1.service.impl;

import com.commit.dbtest1.entity.Camping;
import com.commit.dbtest1.repository.CampingRepository;
import com.commit.dbtest1.service.CampingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CampingServiceImpl implements CampingService {

    private final CampingRepository campingRepository;

    @Autowired
    public CampingServiceImpl(CampingRepository campingRepository) {
        this.campingRepository = campingRepository;
    }

    @Override
    public Optional<Camping> findById(Long campId) {
        return campingRepository.findById(campId);
    }

    @Override
    public List<Camping> filterByAttributes(String doName, String sigunguName) {
        return campingRepository.filterByAttributes(doName, sigunguName);
    }
}
