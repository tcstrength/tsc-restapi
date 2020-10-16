package com.github.tsctrength.tsc.web.repo;

import com.github.tsctrength.tsc.web.model.UserTranDay;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTranDayRepo extends MongoRepository<UserTranDay, String> {
    List<UserTranDay> findByUserIdOrderByYmd(String userId);
    List<UserTranDay> findByUserIdAndYmd(String userId, Integer ymd);
    List<UserTranDay> findByUserIdAndYmdBetweenOrderByYmd(String userId, Integer from, Integer to);
    List<UserTranDay> findByUserIdOrderByYmdDesc(String userId, Pageable page);
}
