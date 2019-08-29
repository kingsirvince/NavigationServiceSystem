package com.company.project.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "general_dynamic")
public class GeneralDynamic {
    @Column(name = "Position_name")
    private String positionName;

    @Column(name = "Position_ID")
    private String positionId;

    @Column(name = "Longitude")
    private BigDecimal longitude;

    @Column(name = "Latitude")
    private BigDecimal latitude;

    @Column(name = "Max")
    private String max;

    @Column(name = "Surplus")
    private String surplus;

    /**
     * @return Position_name
     */
    public String getPositionName() {
        return positionName;
    }

    /**
     * @param positionName
     */
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    /**
     * @return Position_ID
     */
    public String getPositionId() {
        return positionId;
    }

    /**
     * @param positionId
     */
    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    /**
     * @return Longitude
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * @param longitude
     */
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    /**
     * @return Latitude
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * @param latitude
     */
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    /**
     * @return Max
     */
    public String getMax() {
        return max;
    }

    /**
     * @param max
     */
    public void setMax(String max) {
        this.max = max;
    }

    /**
     * @return Surplus
     */
    public String getSurplus() {
        return surplus;
    }

    /**
     * @param surplus
     */
    public void setSurplus(String surplus) {
        this.surplus = surplus;
    }
}