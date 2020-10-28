package com.github.tsctrength.tsc.web.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="processing.log")
public class ProcessingLog {
    private Long partitionId;
    private Long epochId;
    private Integer numMsg;
    private Integer insertMs;
    private Integer processMs;
}
