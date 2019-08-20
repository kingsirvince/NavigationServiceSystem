package com.company.project.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "bridge_info")
public class BridgeInfo {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Bridge_name")
    private String bridgeName;

    @Column(name = "Bridge_ID")
    private String bridgeId;

    @Column(name = "Longitude_A")
    private BigDecimal longitudeA;

    @Column(name = "Latitude_A")
    private BigDecimal latitudeA;

    @Column(name = "Longitude_B")
    private BigDecimal longitudeB;

    @Column(name = "Latitude_B")
    private BigDecimal latitudeB;

    @Column(name = "Longitude_C")
    private BigDecimal longitudeC;

    @Column(name = "Latitude_C")
    private BigDecimal latitudeC;

    @Column(name = "Pier_longitude_left")
    private BigDecimal pierLongitudeLeft;

    @Column(name = "Pier_latitude_left")
    private BigDecimal pierLatitudeLeft;

    @Column(name = "Pier_longitude_right")
    private BigDecimal pierLongitudeRight;

    @Column(name = "Pier_latitude_right")
    private BigDecimal pierLatitudeRight;

    @Column(name = "Bridge_max_limit_height")
    private String bridgeMaxLimitHeight;

    @Column(name = "Bridge_limit_height")
    private String bridgeLimitHeight;

    @Column(name = "Bridge_limit_width")
    private String bridgeLimitWidth;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
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
     * @return Bridge_name
     */
    public String getBridgeName() {
        return bridgeName;
    }

    /**
     * @param bridgeName
     */
    public void setBridgeName(String bridgeName) {
        this.bridgeName = bridgeName;
    }

    /**
     * @return Bridge_ID
     */
    public String getBridgeId() {
        return bridgeId;
    }

    /**
     * @param bridgeId
     */
    public void setBridgeId(String bridgeId) {
        this.bridgeId = bridgeId;
    }

    /**
     * @return Longitude_A
     */
    public BigDecimal getLongitudeA() {
        return longitudeA;
    }

    /**
     * @param longitudeA
     */
    public void setLongitudeA(BigDecimal longitudeA) {
        this.longitudeA = longitudeA;
    }

    /**
     * @return Latitude_A
     */
    public BigDecimal getLatitudeA() {
        return latitudeA;
    }

    /**
     * @param latitudeA
     */
    public void setLatitudeA(BigDecimal latitudeA) {
        this.latitudeA = latitudeA;
    }

    /**
     * @return Longitude_B
     */
    public BigDecimal getLongitudeB() {
        return longitudeB;
    }

    /**
     * @param longitudeB
     */
    public void setLongitudeB(BigDecimal longitudeB) {
        this.longitudeB = longitudeB;
    }

    /**
     * @return Latitude_B
     */
    public BigDecimal getLatitudeB() {
        return latitudeB;
    }

    /**
     * @param latitudeB
     */
    public void setLatitudeB(BigDecimal latitudeB) {
        this.latitudeB = latitudeB;
    }

    /**
     * @return Longitude_C
     */
    public BigDecimal getLongitudeC() {
        return longitudeC;
    }

    /**
     * @param longitudeC
     */
    public void setLongitudeC(BigDecimal longitudeC) {
        this.longitudeC = longitudeC;
    }

    /**
     * @return Latitude_C
     */
    public BigDecimal getLatitudeC() {
        return latitudeC;
    }

    /**
     * @param latitudeC
     */
    public void setLatitudeC(BigDecimal latitudeC) {
        this.latitudeC = latitudeC;
    }

    /**
     * @return Pier_longitude_left
     */
    public BigDecimal getPierLongitudeLeft() {
        return pierLongitudeLeft;
    }

    /**
     * @param pierLongitudeLeft
     */
    public void setPierLongitudeLeft(BigDecimal pierLongitudeLeft) {
        this.pierLongitudeLeft = pierLongitudeLeft;
    }

    /**
     * @return Pier_latitude_left
     */
    public BigDecimal getPierLatitudeLeft() {
        return pierLatitudeLeft;
    }

    /**
     * @param pierLatitudeLeft
     */
    public void setPierLatitudeLeft(BigDecimal pierLatitudeLeft) {
        this.pierLatitudeLeft = pierLatitudeLeft;
    }

    /**
     * @return Pier_longitude_right
     */
    public BigDecimal getPierLongitudeRight() {
        return pierLongitudeRight;
    }

    /**
     * @param pierLongitudeRight
     */
    public void setPierLongitudeRight(BigDecimal pierLongitudeRight) {
        this.pierLongitudeRight = pierLongitudeRight;
    }

    /**
     * @return Pier_latitude_right
     */
    public BigDecimal getPierLatitudeRight() {
        return pierLatitudeRight;
    }

    /**
     * @param pierLatitudeRight
     */
    public void setPierLatitudeRight(BigDecimal pierLatitudeRight) {
        this.pierLatitudeRight = pierLatitudeRight;
    }

    /**
     * @return Bridge_max_limit_height
     */
    public String getBridgeMaxLimitHeight() {
        return bridgeMaxLimitHeight;
    }

    /**
     * @param bridgeMaxLimitHeight
     */
    public void setBridgeMaxLimitHeight(String bridgeMaxLimitHeight) {
        this.bridgeMaxLimitHeight = bridgeMaxLimitHeight;
    }

    /**
     * @return Bridge_limit_height
     */
    public String getBridgeLimitHeight() {
        return bridgeLimitHeight;
    }

    /**
     * @param bridgeLimitHeight
     */
    public void setBridgeLimitHeight(String bridgeLimitHeight) {
        this.bridgeLimitHeight = bridgeLimitHeight;
    }

    /**
     * @return Bridge_limit_width
     */
    public String getBridgeLimitWidth() {
        return bridgeLimitWidth;
    }

    /**
     * @param bridgeLimitWidth
     */
    public void setBridgeLimitWidth(String bridgeLimitWidth) {
        this.bridgeLimitWidth = bridgeLimitWidth;
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