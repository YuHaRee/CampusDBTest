package com.commit.dbtest1.service;

import com.commit.dbtest1.dto.CampingDTO;
import java.util.List;
import java.util.Optional;


public interface CampingService {
    Optional<CampingDTO> findById(Long campId);
    List<CampingDTO> findAll();
    List<CampingDTO> findByDoName(String doName);
    List<CampingDTO> findBySigunguName(String sigunguName);
    List<CampingDTO> findByDoNameAndSigunguName(String doName, String sigunguName);
}
