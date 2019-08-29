package com.company.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "water_depth_info")
public class WaterDepthInfo {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Channel_ID")
    private String channelId;

    @Column(name = "Water_depth_ID")
    private String waterDepthId;

    @Column(name = "Water_depth_longitude")
    private BigDecimal waterDepthLongitude;

    @Column(name = "Water_depth_latitude")
    private BigDecimal waterDepthLatitude;

    @Column(name = "Water_depth_value")
    private String waterDepthValue;

    @Column(name = "Datetime")
    private Date datetime;

    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return Channel_ID
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * @param channelId
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    /**
     * @return Water_depth_ID
     */
    public String getWaterDepthId() {
        return waterDepthId;
    }

    /**
     * @param waterDepthId
     */
    public void setWaterDepthId(String waterDepthId) {
        this.waterDepthId = waterDepthId;
    }

    /**
     * @return Water_depth_longitude
     */
    public BigDecimal getWaterDepthLongitude() {
        return waterDepthLongitude;
    }

    /**
     * @param waterDepthLongitude
     */
    public void setWaterDepthLongitude(BigDecimal waterDepthLongitude) {
        this.waterDepthLongitude = waterDepthLongitude;
    }

    /**
     * @return Water_depth_latitude
     */
    public BigDecimal getWaterDepthLatitude() {
        return waterDepthLatitude;
    }

    /**
     * @param waterDepthLatitude
     */
    public void setWaterDepthLatitude(BigDecimal waterDepthLatitude) {
        this.waterDepthLatitude = waterDepthLatitude;
    }

    /**
     * @return Water_depth_value
     */
    public String getWaterDepthValue() {
        return waterDepthValue;
    }

    /**
     * @param waterDepthValue
     */
    public void setWaterDepthValue(String waterDepthValue) {
        this.waterDepthValue = waterDepthValue;
    }

    /**
     * @return Datetime
     */
    public Date getDatetime() {
        return datetime;
    }

    /**
     * @param datetime
     */
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}