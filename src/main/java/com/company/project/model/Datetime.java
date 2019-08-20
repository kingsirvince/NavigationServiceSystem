package com.company.project.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.sql.Date;

@Data
public class Datetime {
    private Integer id;
    private String name;
    private String age;
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date  datetime;

}
