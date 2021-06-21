package com.cloudproject.server.Repository;

import com.cloudproject.server.Model.DailyRank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyRankRepository extends MongoRepository<DailyRank, String> {
    DailyRank findDailyRankByCategoryIdAndCollectedDate(String categoryId, String collectedDate);
    boolean existsDailyRankByCategoryIdAndCollectedDate(String categoryId, String collectedDate);

    @Query(value = "{'categoryId': ?0}", fields = "{'collectedDate': 1, '_id': 0}")
    List<String> findAllDateByCategoryId(String categoryId);
}
