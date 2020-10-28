package com.github.tsctrength.tsc.web.repo;

import com.github.tsctrength.tsc.web.model.ProcessingLog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessingLogRepo extends MongoRepository<ProcessingLog, String> {
}
