package com.github.tsctrength.tsc.web.service;

import com.github.tsctrength.tsc.web.DateYmd;
import com.github.tsctrength.tsc.web.model.UserTranDay;
import com.github.tsctrength.tsc.web.repo.UserTranDayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserTranDayService {
    @Autowired
    private UserTranDayRepo userTranDayRepo;

    @Autowired
    private DateYmd dateYmd;

    public List<UserTranDay> findByUserId(String userId) {
        return userTranDayRepo.findByUserIdOrderByYmd(userId);
    }

    public List<UserTranDay> findByUserIdAndYmd(String userId, Integer ymd) {
        return userTranDayRepo.findByUserIdAndYmd(userId, ymd);
    }

    public List<UserTranDay> findByUserIdAndYmdBetween(String userId, Integer from, Integer to) {
        return userTranDayRepo.findByUserIdAndYmdBetweenOrderByYmd(userId, from, to);
    }

    public Integer countInactiveDay(String userId) {
        Pageable page = PageRequest.of(0, 1);
        var utd = userTranDayRepo.findByUserIdOrderByYmdDesc(userId, page).get(0);
        var to = new Date();
        try {
            var from = new SimpleDateFormat("yyMMdd").parse(utd.getYmd().toString());
            var diff = to.getTime() - from.getTime();
            return Math.toIntExact(diff / (1000 * 60 * 60 * 24));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
