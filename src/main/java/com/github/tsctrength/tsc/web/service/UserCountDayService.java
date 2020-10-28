package com.github.tsctrength.tsc.web.service;

import com.github.tsctrength.tsc.web.model.UserCountDay;
import com.github.tsctrength.tsc.web.repo.UserCountDayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCountDayService {
    @Autowired
    UserCountDayRepo userCountDayRepo;

    public List<UserCountDay> top100Users() {
        var page = PageRequest.of(0, 10, Sort.Direction.DESC, "count");
        return userCountDayRepo.findAll(page).toList();
    }

    public UserCountDay get(int userId, int ymd) {
        return userCountDayRepo.findByYmdAndUserId(ymd, userId);
    }
}
