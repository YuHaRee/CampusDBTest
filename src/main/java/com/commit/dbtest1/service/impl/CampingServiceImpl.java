package com.commit.dbtest1.service.impl;

import com.commit.dbtest1.dto.CampingDTO;
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
    public Optional<CampingDTO> findById(Long campId) {
        return campingRepository.findDTOById(campId);
    }

    @Override
    public List<CampingDTO> findAll() {
        return campingRepository.findAllDTO();
    }

    @Override
    public List<CampingDTO> findByDoName(String doName) {
        return campingRepository.findDTOByDoName(doName);
    }

    @Override
    public List<CampingDTO> findBySigunguName(String sigunguName) {
        return campingRepository.findDTOBySigunguName(sigunguName);
    }

    @Override
    public List<CampingDTO> findByDoNameAndSigunguName(String doName, String sigunguName) {
        return campingRepository.findDTOByDoNameAndSigunguName(doName, sigunguName);
    }
}
