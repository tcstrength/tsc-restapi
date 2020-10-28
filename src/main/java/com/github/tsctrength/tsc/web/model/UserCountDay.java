package com.github.tsctrength.tsc.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "usercount.day")
@Data
@AllArgsConstructor
public class UserCountDay {
    @Id
    private String _id;
    private Integer userId;
    private Integer ymd;
    private Long count;
}
