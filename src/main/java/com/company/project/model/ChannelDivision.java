package com.company.project.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 航道划分，未使用
 */
@Data
public class ChannelDivision {
    private String channelDivisionID;
    private BigDecimal longitudeMax;
    private BigDecimal longitudeMin;
    private BigDecimal latitudeMax;
    private BigDecimal latitudeMin;


//    public ChannelDivision(channelDivisionID,longitudeMax,longitudeMin,latitudeMax,latitudeMin){
//        this.channelDivisionID= channelDivisionID;
//        this.longitudeMax=longitudeMax;
//        this.longitudeMin=longitudeMin;
//        this.latitudeMax=latitudeMax;
//        this.latitudeMin=latitudeMin;
//
//    }

}
