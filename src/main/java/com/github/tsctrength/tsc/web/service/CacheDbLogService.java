package com.github.tsctrength.tsc.web.service;

import com.github.tsctrength.tsc.web.model.CacheDbAgg;
import com.github.tsctrength.tsc.web.model.CacheDbLog;
import com.github.tsctrength.tsc.web.model.ProcessingLog;
import com.github.tsctrength.tsc.web.repo.CacheDbAggRepo;
import com.github.tsctrength.tsc.web.repo.CacheDbLogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CacheDbLogService {
    @Autowired
    CacheDbLogRepo cacheDbLogRepo;

    @Autowired
    CacheDbAggRepo cacheDbAggRepo;

    public Long getNumFailures() {
        return cacheDbLogRepo.countByStatus(false);
    }

    public List<CacheDbLog> top5Highest() {
        Pageable page = PageRequest.of(0, 5, Sort.Direction.DESC, "dbMs");
        return cacheDbLogRepo.findAll(page).toList();
    }

    public List<CacheDbLog> top5Lowest() {
        Pageable page = PageRequest.of(0, 5, Sort.Direction.ASC, "dbMs");
        return cacheDbLogRepo.findAll(page).toList();
    }

    public CacheDbAgg getAgg() {
        return cacheDbAggRepo.getCacheDbAgg();
    }
}
