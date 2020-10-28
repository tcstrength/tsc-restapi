package com.github.tsctrength.tsc.web.controller;

import com.github.tsctrength.tsc.web.DateYmd;
import com.github.tsctrength.tsc.web.model.ProcessingLog;
import com.github.tsctrength.tsc.web.model.UserCountDay;
import com.github.tsctrength.tsc.web.service.CacheDbLogService;
import com.github.tsctrength.tsc.web.service.ProcessingLogService;
import com.github.tsctrength.tsc.web.service.UserCountDayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class UiController {
    @Autowired
    DateYmd dateYmd;

    @Autowired
    CacheDbLogService cacheDbLogService;

    @Autowired
    ProcessingLogService processingLogService;

    @Autowired
    UserCountDayService userCountDayService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("cacheDbAgg", cacheDbLogService.getAgg());
        model.addAttribute("processingAgg", processingLogService.getProcessingAgg());
        model.addAttribute("topHighestProcessingLog", processingLogService.top5Highest());
        model.addAttribute("topLowestProcessingLog", processingLogService.top5Lowest());
        model.addAttribute("topHighestCacheDbLog", cacheDbLogService.top5Highest());
        model.addAttribute("topLowestCacheDbLog", cacheDbLogService.top5Lowest());
        model.addAttribute("numInsertFailures", cacheDbLogService.getNumFailures());
        model.addAttribute("topUserCountDay", userCountDayService.top100Users());
        return "home";
    }
}
