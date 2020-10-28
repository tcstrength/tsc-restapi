package com.github.tsctrength.tsc.web.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "cachedb.log")
public class CacheDbLog {
    private Integer ymd;
    private Integer userId;
    private Integer count;
    private Integer cacheMs;
    private Integer dbMs;
    private Boolean status;
}
