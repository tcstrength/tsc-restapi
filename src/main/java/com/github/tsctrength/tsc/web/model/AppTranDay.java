package com.github.tsctrength.tsc.web.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "apptran.day")
public class AppTranDay {
    @Id
    private String atdId;
    private String appId;
    private Integer ymd;
    private Long cost;
    private Long fee;
    private Long count;
    private Long modifiedTime = new Date().getTime();
}
