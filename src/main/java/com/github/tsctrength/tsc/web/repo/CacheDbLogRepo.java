package com.github.tsctrength.tsc.web.repo;

import com.github.tsctrength.tsc.web.model.CacheDbLog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CacheDbLogRepo extends MongoRepository<CacheDbLog, String> {
    Long countByStatus(Boolean status);
//    List<CacheDbLog> findOrderByDbMsAsc(Pageable pageable);
//    List<CacheDbLog> findOrderByDbMsDesc(Pageable pageable);
}
