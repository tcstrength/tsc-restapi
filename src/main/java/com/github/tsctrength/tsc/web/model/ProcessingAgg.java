package com.github.tsctrength.tsc.web.model;

import lombok.Data;

@Data
public class ProcessingAgg {
    private float avgInsertMs;
    private float avgProcessMs;
    private Long totalCount;
}
