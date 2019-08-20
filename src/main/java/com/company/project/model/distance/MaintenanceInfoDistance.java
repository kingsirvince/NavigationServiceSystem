package com.company.project.model.distance;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "maintenance_info")
public class MaintenanceInfoDistance {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "distance")
    private Integer distance;

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }


    @Column(name = "Maintenance_name")
    private String maintenanceName;

    @Column(name = "Maintenance_ID")
    private String maintenanceId;

    @Column(name = "Maintenance_longitude")
    private BigDecimal maintenanceLongitude;

    @Column(name = "Maintenance_latitude")
    private BigDecimal maintenanceLatitude;
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
     * @return Maintenance_name
     */
    public String getMaintenanceName() {
        return maintenanceName;
    }

    /**
     * @param maintenanceName
     */
    public void setMaintenanceName(String maintenanceName) {
        this.maintenanceName = maintenanceName;
    }

    /**
     * @return Maintenance_ID
     */
    public String getMaintenanceId() {
        return maintenanceId;
    }

    /**
     * @param maintenanceId
     */
    public void setMaintenanceId(String maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    /**
     * @return Maintenance_longitude
     */
    public BigDecimal getMaintenanceLongitude() {
        return maintenanceLongitude;
    }

    /**
     * @param maintenanceLongitude
     */
    public void setMaintenanceLongitude(BigDecimal maintenanceLongitude) {
        this.maintenanceLongitude = maintenanceLongitude;
    }

    /**
     * @return Maintenance_latitude
     */
    public BigDecimal getMaintenanceLatitude() {
        return maintenanceLatitude;
    }

    /**
     * @param maintenanceLatitude
     */
    public void setMaintenanceLatitude(BigDecimal maintenanceLatitude) {
        this.maintenanceLatitude = maintenanceLatitude;
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