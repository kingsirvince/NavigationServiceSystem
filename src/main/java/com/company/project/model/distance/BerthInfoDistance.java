package com.company.project.model.distance;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

public class BerthInfoDistance {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Service_name")
    private String serviceName;

    @Column(name = "Service_ID")
    private String serviceId;

    @Column(name = "Service_longitude")
    private BigDecimal serviceLongitude;

    @Column(name = "Service_latitude")
    private BigDecimal serviceLatitude;

    @Column(name = "Berth_name")
    private String berthName;

    @Column(name = "Berth_ID")
    private String berthId;

    @Column(name = "Berth_max_cy")
    private Integer berthMaxCy;

    @Column(name = "Berth_surplus_cy")
    private Integer berthSurplusCy;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "Datetime")
    private Date datetime;

}
