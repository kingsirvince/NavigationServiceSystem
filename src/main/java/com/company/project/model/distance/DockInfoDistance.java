package com.company.project.model.distance;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "dock_info")
public class DockInfoDistance {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer distance;

    @Column(name = "Dock_name")
    private String dockName;

    @Column(name = "Dock_ID")
    private String dockId;


    @Column(name = "Dock_max_tonnage")
    private String dockMaxTonnage;

    @Column(name = "Dock_longitude")
    private BigDecimal dockLongitude;

    @Column(name = "Dock_latitude")
    private BigDecimal dockLatitude;

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

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

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
     * @return Dock_name
     */
    public String getDockName() {
        return dockName;
    }

    /**
     * @param dockName
     */
    public void setDockName(String dockName) {
        this.dockName = dockName;
    }

    /**
     * @return Dock_ID
     */
    public String getDockId() {
        return dockId;
    }

    /**
     * @param dockId
     */
    public void setDockId(String dockId) {
        this.dockId = dockId;
    }



    /**
     * @return Dock_max_tonnage
     */
    public String getDockMaxTonnage() {
        return dockMaxTonnage;
    }

    /**
     * @param dockMaxTonnage
     */
    public void setDockMaxTonnage(String dockMaxTonnage) {
        this.dockMaxTonnage = dockMaxTonnage;
    }

    /**
     * @return Dock_longitude
     */
    public BigDecimal getDockLongitude() {
        return dockLongitude;
    }

    /**
     * @param dockLongitude
     */
    public void setDockLongitude(BigDecimal dockLongitude) {
        this.dockLongitude = dockLongitude;
    }

    /**
     * @return Dock_latitude
     */
    public BigDecimal getDockLatitude() {
        return dockLatitude;
    }

    /**
     * @param dockLatitude
     */
    public void setDockLatitude(BigDecimal dockLatitude) {
        this.dockLatitude = dockLatitude;
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

    public String getBerthName() {
        return berthName;
    }

    public void setBerthName(String berthName) {
        this.berthName = berthName;
    }

    public String getBerthId() {
        return berthId;
    }

    public void setBerthId(String berthId) {
        this.berthId = berthId;
    }

    public Integer getBerthMaxCy() {
        return berthMaxCy;
    }

    public void setBerthMaxCy(Integer berthMaxCy) {
        this.berthMaxCy = berthMaxCy;
    }

    public Integer getBerthSurplusCy() {
        return berthSurplusCy;
    }

    public void setBerthSurplusCy(Integer berthSurplusCy) {
        this.berthSurplusCy = berthSurplusCy;
    }
}