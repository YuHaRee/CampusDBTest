package com.commit.dbtest1.repository;

import com.commit.dbtest1.dto.CampingDTO;

import java.util.List;
import java.util.Optional;


public interface CampingRepository {

    // 캠핑장 ID로 캠핑장을 조회하고, DTO로 반환
    Optional<CampingDTO> findDTOById(Long campId);

    // 모든 캠핑장을 조회하고, DTO 리스트로 반환
    List<CampingDTO> findAllDTO();

    // 특정 도 이름으로 캠핑장을 조회하고, DTO 리스트로 반환
    List<CampingDTO> findDTOByDoName(String doName);

    // 특정 시군구 이름으로 캠핑장을 조회하고, DTO 리스트로 반환
    List<CampingDTO> findDTOBySigunguName(String sigunguName);

    // 특정 도 이름과 시군구 이름으로 캠핑장을 조회하고, DTO 리스트로 반환
    List<CampingDTO> findDTOByDoNameAndSigunguName(String doName, String sigunguName);
}
