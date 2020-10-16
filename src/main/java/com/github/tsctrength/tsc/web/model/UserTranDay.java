package com.github.tsctrength.tsc.web.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "usertran.day")
@Data
public class UserTranDay {
    @Id
    private String utdId;
    private String userId;
    private Integer ymd;
    private Long cost;
    private Long fee;
    private Long count;
    private Long modifiedTime = new Date().getTime();
}
