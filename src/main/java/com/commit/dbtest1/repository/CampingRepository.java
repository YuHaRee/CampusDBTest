package com.commit.dbtest1.repository;

import com.commit.dbtest1.entity.Camping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampingRepository extends JpaRepository<Camping, Long> {
    
}

