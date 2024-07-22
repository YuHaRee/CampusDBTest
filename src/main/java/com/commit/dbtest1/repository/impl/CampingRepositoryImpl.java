package com.commit.dbtest1.repository.impl;

import com.commit.dbtest1.dto.CampingDTO;
import com.commit.dbtest1.entity.Camping;
import com.commit.dbtest1.repository.CampingRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
    CampingRepository 인터페이스를 구현
    엔티티를 조회하여 DTO로 변환하는 로직을 포함
*/
@Repository
@Transactional
public class CampingRepositoryImpl implements CampingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<CampingDTO> findDTOById(Long campId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Camping> cq = cb.createQuery(Camping.class);
        Root<Camping> root = cq.from(Camping.class);
        cq.select(root).where(cb.equal(root.get("campId"), campId));

        Camping camping = entityManager.createQuery(cq).getSingleResult();
        return Optional.ofNullable(toDTO(camping));
    }

    @Override
    public List<CampingDTO> findAllDTO() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Camping> cq = cb.createQuery(Camping.class);
        Root<Camping> root = cq.from(Camping.class);
        cq.select(root);

        List<Camping> campings = entityManager.createQuery(cq).getResultList();
        return campings.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<CampingDTO> findDTOByDoName(String doName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Camping> cq = cb.createQuery(Camping.class);
        Root<Camping> root = cq.from(Camping.class);
        cq.select(root).where(cb.equal(root.get("doName"), doName));

        List<Camping> campings = entityManager.createQuery(cq).getResultList();
        return campings.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<CampingDTO> findDTOBySigunguName(String sigunguName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Camping> cq = cb.createQuery(Camping.class);
        Root<Camping> root = cq.from(Camping.class);
        cq.select(root).where(cb.equal(root.get("sigunguName"), sigunguName));

        List<Camping> campings = entityManager.createQuery(cq).getResultList();
        return campings.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<CampingDTO> findDTOByDoNameAndSigunguName(String doName, String sigunguName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Camping> cq = cb.createQuery(Camping.class);
        Root<Camping> root = cq.from(Camping.class);
        cq.select(root).where(cb.equal(root.get("doName"), doName), cb.equal(root.get("sigunguName"), sigunguName));

        List<Camping> campings = entityManager.createQuery(cq).getResultList();
        return campings.stream().map(this::toDTO).collect(Collectors.toList());
    }

    /**
     * 엔티티를 DTO로 변환하는 메서드
     * @param camping 캠핑 엔티티
     * @return CampingDTO
     */
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
                .build();
    }
}
