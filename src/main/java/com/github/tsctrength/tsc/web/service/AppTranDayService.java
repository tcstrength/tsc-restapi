package com.github.tsctrength.tsc.web.service;

import com.github.tsctrength.tsc.web.model.AppTranDay;
import com.github.tsctrength.tsc.web.repo.AppTranDayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppTranDayService {
    @Autowired
    AppTranDayRepo appTranDayRepo;

    public List<AppTranDay> findByAppId(String appId) {
        return appTranDayRepo.findByAppId(appId);
    }

    public List<AppTranDay> findByAppIdAndYmd(String appId, Integer ymd) {
        return appTranDayRepo.findByAppIdAndYmd(appId, ymd);
    }
}
