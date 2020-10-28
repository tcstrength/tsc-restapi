package com.github.tsctrength.tsc.web.service;

import com.github.tsctrength.tsc.web.model.CacheDbLog;
import com.github.tsctrength.tsc.web.model.ProcessingAgg;
import com.github.tsctrength.tsc.web.model.ProcessingLog;
import com.github.tsctrength.tsc.web.repo.ProcessingAggRepo;
import com.github.tsctrength.tsc.web.repo.ProcessingLogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessingLogService {
    @Autowired
    ProcessingAggRepo processingAggRepo;

    @Autowired
    ProcessingLogRepo processingLogRepo;

    public ProcessingAgg getProcessingAgg() {
        return processingAggRepo.getProcessingAgg();
    }

    public List<ProcessingLog> top5Highest() {
        Pageable page = PageRequest.of(0, 5, Sort.Direction.DESC, "processMs");
        return processingLogRepo.findAll(page).toList();
    }

    public List<ProcessingLog> top5Lowest() {
        Pageable page = PageRequest.of(0, 5, Sort.Direction.ASC, "processMs");
        return processingLogRepo.findAll(page).toList();
    }
}
