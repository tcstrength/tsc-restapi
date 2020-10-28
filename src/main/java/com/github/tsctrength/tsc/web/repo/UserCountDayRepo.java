package com.github.tsctrength.tsc.web.repo;

import com.github.tsctrength.tsc.web.model.UserCountDay;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCountDayRepo extends MongoRepository<UserCountDay, String> {
    UserCountDay findByYmdAndUserId(int ymd, int userId);
}
