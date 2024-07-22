package com.commit.dbtest1.service;

import com.commit.dbtest1.entity.Camping;
import java.util.List;
import java.util.Optional;

public interface CampingService {
    Optional<Camping> findById(Long campId);
    List<Camping> filterByAttributes(String doName, String sigunguName);
}
