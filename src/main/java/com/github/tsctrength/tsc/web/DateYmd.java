package com.github.tsctrength.tsc.web;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateYmd {
    public Integer currentYmd() {
        var date = new Date();
        var ymd = new SimpleDateFormat("yyMMdd").format(date.getTime());
        return Integer.parseInt(ymd);
    }
}
