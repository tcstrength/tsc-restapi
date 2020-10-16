package com.github.tsctrength.tsc.web.repo;

import com.github.tsctrength.tsc.web.model.AppTranDay;
import com.github.tsctrength.tsc.web.model.UserTranDay;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppTranDayRepo extends MongoRepository<AppTranDay, String> {
    List<AppTranDay> findByAppId(String appId);
    List<AppTranDay> findByAppIdAndYmd(String appId, Integer ymd);
    List<AppTranDay> findByAppIdAndYmdBetween(String appId, Integer from, Integer to);
}
