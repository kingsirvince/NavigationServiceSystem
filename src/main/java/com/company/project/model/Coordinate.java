package com.company.project.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 经纬度坐标
 */
@Data
public class Coordinate {
    private BigDecimal longitude;
    private BigDecimal latitude;
    public Coordinate(BigDecimal longitude, BigDecimal latitude){
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
