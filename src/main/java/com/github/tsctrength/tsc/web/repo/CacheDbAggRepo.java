package com.github.tsctrength.tsc.web.repo;

import com.github.tsctrength.tsc.web.model.CacheDbAgg;
import com.github.tsctrength.tsc.web.model.CacheDbLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;

@Repository
public class CacheDbAggRepo {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public CacheDbAggRepo(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public CacheDbAgg getCacheDbAgg() {
        var agg = Aggregation.newAggregation(
            group()
            .sum("count")
            .as("totalCount")
            .sum("dbMs")
            .as("totalDbMs")
            .sum("cacheMs")
            .as("totalCacheMs"),
            project()
            .and(ArithmeticOperators.Divide.valueOf("totalDbMs")
                .divideBy("totalCount")).as("avgDbMs")
            .and(ArithmeticOperators.Divide.valueOf("totalCacheMs")
                .divideBy("totalCount")).as("avgCacheMs")
        );

        return mongoTemplate.aggregate(agg, CacheDbLog.class, CacheDbAgg.class)
            .getMappedResults()
            .get(0);
    }
}
