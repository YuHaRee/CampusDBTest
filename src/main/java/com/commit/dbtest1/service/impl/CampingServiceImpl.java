package com.commit.dbtest1.service.impl;

import com.commit.dbtest1.dto.CampingDTO;
import com.commit.dbtest1.entity.Camping;
import com.commit.dbtest1.repository.CampingRepository;
import com.commit.dbtest1.service.CampingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CampingServiceImpl implements CampingService {

    private final CampingRepository campingRepository;

    @Autowired
    public CampingServiceImpl(CampingRepository campingRepository) {
        this.campingRepository = campingRepository;
    }

    @Override
    public Optional<CampingDTO> findById(Long campId) {
        return campingRepository.findById(campId).map(this::toDTO);
    }

    @Override
    public List<CampingDTO> getCampingsWithCursor(CampingDTO filter, LocalDateTime cursor, int limit) {
        List<Camping> campings = campingRepository.findAll().stream()
                .filter(c -> (filter.getDoName() == null || c.getDoName().equals(filter.getDoName())) &&
                        (filter.getSigunguName() == null || c.getSigunguName().equals(filter.getSigunguName())) &&
                        (filter.getInduty() == null || c.getInduty().equals(filter.getInduty())) &&
                        c.getCreatedDate().isAfter(cursor))
                .sorted((c1, c2) -> c1.getCreatedDate().compareTo(c2.getCreatedDate()))
                .limit(limit)
                .collect(Collectors.toList());

        return campings.stream().map(this::toDTO).collect(Collectors.toList());
    }

    private CampingDTO toDTO(Camping camping) {
        return CampingDTO.builder()
                .campId(camping.getCampId())
                .campName(camping.getCampName())
                .lineIntro(camping.getLineIntro())
                .intro(camping.getIntro())
                .doName(camping.getDoName())
                .sigunguName(camping.getSigunguName())
                .postCode(camping.getPostCode())
                .featureSummary(camping.getFeatureSummary())
                .induty(camping.getInduty())
                .addr(camping.getAddr())
                .addrDetails(camping.getAddrDetails())
                .mapX(camping.getMapX())
                .mapY(camping.getMapY())
                .tel(camping.getTel())
                .homepage(camping.getHomepage())
                .staffCnt(camping.getStaffCnt())
                .createdDate(camping.getCreatedDate())
                .modifiedDate(camping.getModifiedDate())
                .build();
    }
}
