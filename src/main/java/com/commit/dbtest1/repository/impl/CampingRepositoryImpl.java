package com.commit.dbtest1.repository.impl;

import com.commit.dbtest1.entity.Camping;
import com.commit.dbtest1.repository.CampingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import java.util.List;
import java.util.Optional;

@Repository
public class CampingRepositoryImpl implements CampingRepository {

    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;

    @Autowired
    public CampingRepositoryImpl(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        this.dynamoDbEnhancedClient = dynamoDbEnhancedClient;
    }

    @Override
    public Optional<Camping> findById(Long campId) {
        try {
            DynamoDbTable<Camping> table = dynamoDbEnhancedClient.table("Camping", TableSchema.fromBean(Camping.class));
            return Optional.ofNullable(table.getItem(r -> r.key(k -> k.partitionValue(campId))));
        } catch (DynamoDbException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<Camping> filterByAttributes(String doName, String sigunguName) {
        // 필터링 로직 구현
        return null; // 필터링 결과 반환
    }
}
