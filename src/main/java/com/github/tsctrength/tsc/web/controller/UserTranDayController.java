package com.github.tsctrength.tsc.web.controller;

import com.github.tsctrength.tsc.web.DateYmd;
import com.github.tsctrength.tsc.web.model.UserTranDay;
import com.github.tsctrength.tsc.web.service.UserTranDayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/usertd")
public class UserTranDayController {
    @Autowired
    UserTranDayService userTranDayService;

    @Autowired
    DateYmd dateYmd;

    @GetMapping()
    public List<UserTranDay> findUtdFromTo(String userId, Integer from, Integer to, Integer ymd) {
        if (ymd == null) {
            if (from != null && to != null) {
                log.info("Find between");
                return userTranDayService.findByUserIdAndYmdBetween(userId, from, to);
            }

            log.info("Find current Ymd");
            return userTranDayService.findByUserIdAndYmd(userId, dateYmd.currentYmd());
        }

        log.info("Find by Ymd");
        return userTranDayService.findByUserIdAndYmd(userId, ymd);
    }

    @GetMapping("history")
    public List<UserTranDay> findAll(String userId) {
        return userTranDayService.findByUserId(userId);
    }

    @GetMapping("countInactive")
    public Integer countInactiveDay(String userId) {
        return userTranDayService.countInactiveDay(userId);
    }
}
