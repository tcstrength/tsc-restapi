package com.github.tsctrength.tsc.web.repo;

import com.github.tsctrength.tsc.web.model.CacheDbAgg;
import com.github.tsctrength.tsc.web.model.CacheDbLog;
import com.github.tsctrength.tsc.web.model.ProcessingAgg;
import com.github.tsctrength.tsc.web.model.ProcessingLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;

@Repository
public class ProcessingAggRepo {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public ProcessingAggRepo(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public ProcessingAgg getProcessingAgg() {
        var agg = Aggregation.newAggregation(
            group()
                .sum("numMsg")
                .as("totalCount")
                .sum("insertMs")
                .as("totalInsertMs")
                .sum("processMs")
                .as("totalProcessMs"),
            project()
                .and(ArithmeticOperators.Divide.valueOf("totalInsertMs")
                    .divideBy("totalCount")).as("avgInsertMs")
                .and(ArithmeticOperators.Divide.valueOf("totalProcessMs")
                    .divideBy("totalCount")).as("avgProcessMs")
                .and(ArithmeticOperators.Add.valueOf("totalCount")
                    .add(0)).as("totalCount")
        );

        return mongoTemplate.aggregate(agg, ProcessingLog.class, ProcessingAgg.class)
            .getMappedResults()
            .get(0);
    }

    public Long processedTotal() {
        var agg = Aggregation.newAggregation(
            group()
                .sum("numMsg")
                .as("processedTotal"));

        return mongoTemplate.aggregate(agg, ProcessingLog.class, Long.class)
            .getMappedResults()
            .get(0);
    }
}