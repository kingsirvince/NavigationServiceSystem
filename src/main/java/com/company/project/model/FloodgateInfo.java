package com.company.project.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "floodgate_info")
public class FloodgateInfo {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Floodgate_name")
    private String floodgateName;

    @Column(name = "Floodgate_ID")
    private String floodgateId;

    @Column(name = "Floodgate_longitude_A")
    private BigDecimal floodgateLongitudeA;

    @Column(name = "Floodgate_latitude_A")
    private BigDecimal floodgateLatitudeA;

    @Column(name = "Floodgate_longitude_B")
    private BigDecimal floodgateLongitudeB;

    @Column(name = "Floodgate_latitude_B")
    private BigDecimal floodgateLatitudeB;

    @Column(name = "Floodgate_longitude_C")
    private BigDecimal floodgateLongitudeC;

    @Column(name = "Floodgate_latitude_C")
    private BigDecimal floodgateLatitudeC;

    @Column(name = "Floodgate_longitude_left")
    private BigDecimal floodgateLongitudeLeft;

    @Column(name = "Floodgate_latitude_left")
    private BigDecimal floodgateLatitudeLeft;

    @Column(name = "Floodgate_longitude_right")
    private BigDecimal floodgateLongitudeRight;

    @Column(name = "Floodgate_latitude_right")
    private BigDecimal floodgateLatitudeRight;

    @Column(name = "Floodgate_max_limit_height")
    private String floodgateMaxLimitHeight;

    @Column(name = "Floodgate_limit_height")
    private String floodgateLimitHeight;

    @Column(name = "Floodgate_limit_width")
    private String floodgateLimitWidth;
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
     * @return Floodgate_name
     */
    public String getFloodgateName() {
        return floodgateName;
    }

    /**
     * @param floodgateName
     */
    public void setFloodgateName(String floodgateName) {
        this.floodgateName = floodgateName;
    }

    /**
     * @return Floodgate_ID
     */
    public String getFloodgateId() {
        return floodgateId;
    }

    /**
     * @param floodgateId
     */
    public void setFloodgateId(String floodgateId) {
        this.floodgateId = floodgateId;
    }

    /**
     * @return Floodgate_longitude_A
     */
    public BigDecimal getFloodgateLongitudeA() {
        return floodgateLongitudeA;
    }

    /**
     * @param floodgateLongitudeA
     */
    public void setFloodgateLongitudeA(BigDecimal floodgateLongitudeA) {
        this.floodgateLongitudeA = floodgateLongitudeA;
    }

    /**
     * @return Floodgate_latitude_A
     */
    public BigDecimal getFloodgateLatitudeA() {
        return floodgateLatitudeA;
    }

    /**
     * @param floodgateLatitudeA
     */
    public void setFloodgateLatitudeA(BigDecimal floodgateLatitudeA) {
        this.floodgateLatitudeA = floodgateLatitudeA;
    }

    /**
     * @return Floodgate_longitude_B
     */
    public BigDecimal getFloodgateLongitudeB() {
        return floodgateLongitudeB;
    }

    /**
     * @param floodgateLongitudeB
     */
    public void setFloodgateLongitudeB(BigDecimal floodgateLongitudeB) {
        this.floodgateLongitudeB = floodgateLongitudeB;
    }

    /**
     * @return Floodgate_latitude_B
     */
    public BigDecimal getFloodgateLatitudeB() {
        return floodgateLatitudeB;
    }

    /**
     * @param floodgateLatitudeB
     */
    public void setFloodgateLatitudeB(BigDecimal floodgateLatitudeB) {
        this.floodgateLatitudeB = floodgateLatitudeB;
    }

    /**
     * @return Floodgate_longitude_C
     */
    public BigDecimal getFloodgateLongitudeC() {
        return floodgateLongitudeC;
    }

    /**
     * @param floodgateLongitudeC
     */
    public void setFloodgateLongitudeC(BigDecimal floodgateLongitudeC) {
        this.floodgateLongitudeC = floodgateLongitudeC;
    }

    /**
     * @return Floodgate_latitude_C
     */
    public BigDecimal getFloodgateLatitudeC() {
        return floodgateLatitudeC;
    }

    /**
     * @param floodgateLatitudeC
     */
    public void setFloodgateLatitudeC(BigDecimal floodgateLatitudeC) {
        this.floodgateLatitudeC = floodgateLatitudeC;
    }

    /**
     * @return Floodgate_longitude_left
     */
    public BigDecimal getFloodgateLongitudeLeft() {
        return floodgateLongitudeLeft;
    }

    /**
     * @param floodgateLongitudeLeft
     */
    public void setFloodgateLongitudeLeft(BigDecimal floodgateLongitudeLeft) {
        this.floodgateLongitudeLeft = floodgateLongitudeLeft;
    }

    /**
     * @return Floodgate_latitude_left
     */
    public BigDecimal getFloodgateLatitudeLeft() {
        return floodgateLatitudeLeft;
    }

    /**
     * @param floodgateLatitudeLeft
     */
    public void setFloodgateLatitudeLeft(BigDecimal floodgateLatitudeLeft) {
        this.floodgateLatitudeLeft = floodgateLatitudeLeft;
    }

    /**
     * @return Floodgate_longitude_right
     */
    public BigDecimal getFloodgateLongitudeRight() {
        return floodgateLongitudeRight;
    }

    /**
     * @param floodgateLongitudeRight
     */
    public void setFloodgateLongitudeRight(BigDecimal floodgateLongitudeRight) {
        this.floodgateLongitudeRight = floodgateLongitudeRight;
    }

    /**
     * @return Floodgate_latitude_right
     */
    public BigDecimal getFloodgateLatitudeRight() {
        return floodgateLatitudeRight;
    }

    /**
     * @param floodgateLatitudeRight
     */
    public void setFloodgateLatitudeRight(BigDecimal floodgateLatitudeRight) {
        this.floodgateLatitudeRight = floodgateLatitudeRight;
    }

    /**
     * @return Floodgate_max_limit_height
     */
    public String getFloodgateMaxLimitHeight() {
        return floodgateMaxLimitHeight;
    }

    /**
     * @param floodgateMaxLimitHeight
     */
    public void setFloodgateMaxLimitHeight(String floodgateMaxLimitHeight) {
        this.floodgateMaxLimitHeight = floodgateMaxLimitHeight;
    }

    /**
     * @return Floodgate_limit_height
     */
    public String getFloodgateLimitHeight() {
        return floodgateLimitHeight;
    }

    /**
     * @param floodgateLimitHeight
     */
    public void setFloodgateLimitHeight(String floodgateLimitHeight) {
        this.floodgateLimitHeight = floodgateLimitHeight;
    }

    /**
     * @return Floodgate_limit_width
     */
    public String getFloodgateLimitWidth() {
        return floodgateLimitWidth;
    }

    /**
     * @param floodgateLimitWidth
     */
    public void setFloodgateLimitWidth(String floodgateLimitWidth) {
        this.floodgateLimitWidth = floodgateLimitWidth;
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