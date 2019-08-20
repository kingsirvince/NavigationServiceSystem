package com.company.project.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "ship_test")
@Data
public class ShipTest {
    @Id
    @Column(name = "Ship_MMSI")
    private Integer shipMmsi;

    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Ship_call")
    private String shipCall;

    @Column(name = "Ship_class")
    private String shipClass;

    @Column(name = "Ship_state")
    private String shipState;

    @Column(name = "Ship_longitude")
    private BigDecimal shipLongitude;

    @Column(name = "Ship_latitude")
    private BigDecimal shipLatitude;

    @Column(name = "Ship_length")
    private Double shipLength;

    @Column(name = "Ship_width")
    private Double shipWidth;

    @Column(name = "Ship_heading")
    private String shipHeading;

    @Column(name = "Ship_speed")
    private Double shipSpeed;

    @Column(name = "Ship_draught")
    private String shipDraught;

    @Column(name = "Ship_max_load")
    private String shipMaxLoad;

    @Column(name = "Ship_load")
    private String shipLoad;

    //    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "Datetime")
    private Date datetime;

    @Column(name = "Channel_division_ID")
    private String channelDivisionId;
}

