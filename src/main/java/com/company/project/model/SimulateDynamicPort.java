package com.company.project.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "simulate_dynamic_port")
public class SimulateDynamicPort {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String berthMaxCy;

    @Column(name = "Berth_surplus_cy")
    private String berthSurplusCy;

    @Column(name = "Gas_name")
    private String gasName;

    @Column(name = "Gas_ID")
    private String gasId;

    @Column(name = "Charger_name")
    private String chargerName;

    @Column(name = "Charger_ID")
    private String chargerId;

    @Column(name = "Charger_max_cy")
    private String chargerMaxCy;

    @Column(name = "Charger_surplus_cy")
    private String chargerSurplusCy;

    @Column(name = "Recycling_name")
    private String recyclingName;

    @Column(name = "Recycling_ID")
    private String recyclingId;

    @Column(name = "Recycling_max_cy")
    private String recyclingMaxCy;

    @Column(name = "Recycling_surplus_cy")
    private String recyclingSurplusCy;
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
     * @return Service_name
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * @param serviceName
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * @return Service_ID
     */
    public String getServiceId() {
        return serviceId;
    }

    /**
     * @param serviceId
     */
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * @return Service_longitude
     */
    public BigDecimal getServiceLongitude() {
        return serviceLongitude;
    }

    /**
     * @param serviceLongitude
     */
    public void setServiceLongitude(BigDecimal serviceLongitude) {
        this.serviceLongitude = serviceLongitude;
    }

    /**
     * @return Service_latitude
     */
    public BigDecimal getServiceLatitude() {
        return serviceLatitude;
    }

    /**
     * @param serviceLatitude
     */
    public void setServiceLatitude(BigDecimal serviceLatitude) {
        this.serviceLatitude = serviceLatitude;
    }

    /**
     * @return Berth_name
     */
    public String getBerthName() {
        return berthName;
    }

    /**
     * @param berthName
     */
    public void setBerthName(String berthName) {
        this.berthName = berthName;
    }

    /**
     * @return Berth_ID
     */
    public String getBerthId() {
        return berthId;
    }

    /**
     * @param berthId
     */
    public void setBerthId(String berthId) {
        this.berthId = berthId;
    }

    /**
     * @return Berth_max_cy
     */
    public String getBerthMaxCy() {
        return berthMaxCy;
    }

    /**
     * @param berthMaxCy
     */
    public void setBerthMaxCy(String berthMaxCy) {
        this.berthMaxCy = berthMaxCy;
    }

    /**
     * @return Berth_surplus_cy
     */
    public String getBerthSurplusCy() {
        return berthSurplusCy;
    }

    /**
     * @param berthSurplusCy
     */
    public void setBerthSurplusCy(String berthSurplusCy) {
        this.berthSurplusCy = berthSurplusCy;
    }

    /**
     * @return Gas_name
     */
    public String getGasName() {
        return gasName;
    }

    /**
     * @param gasName
     */
    public void setGasName(String gasName) {
        this.gasName = gasName;
    }

    /**
     * @return Gas_ID
     */
    public String getGasId() {
        return gasId;
    }

    /**
     * @param gasId
     */
    public void setGasId(String gasId) {
        this.gasId = gasId;
    }

    /**
     * @return Charger_name
     */
    public String getChargerName() {
        return chargerName;
    }

    /**
     * @param chargerName
     */
    public void setChargerName(String chargerName) {
        this.chargerName = chargerName;
    }

    /**
     * @return Charger_ID
     */
    public String getChargerId() {
        return chargerId;
    }

    /**
     * @param chargerId
     */
    public void setChargerId(String chargerId) {
        this.chargerId = chargerId;
    }

    /**
     * @return Charger_max_cy
     */
    public String getChargerMaxCy() {
        return chargerMaxCy;
    }

    /**
     * @param chargerMaxCy
     */
    public void setChargerMaxCy(String chargerMaxCy) {
        this.chargerMaxCy = chargerMaxCy;
    }

    /**
     * @return Charger_surplus_cy
     */
    public String getChargerSurplusCy() {
        return chargerSurplusCy;
    }

    /**
     * @param chargerSurplusCy
     */
    public void setChargerSurplusCy(String chargerSurplusCy) {
        this.chargerSurplusCy = chargerSurplusCy;
    }

    /**
     * @return Recycling_name
     */
    public String getRecyclingName() {
        return recyclingName;
    }

    /**
     * @param recyclingName
     */
    public void setRecyclingName(String recyclingName) {
        this.recyclingName = recyclingName;
    }

    /**
     * @return Recycling_ID
     */
    public String getRecyclingId() {
        return recyclingId;
    }

    /**
     * @param recyclingId
     */
    public void setRecyclingId(String recyclingId) {
        this.recyclingId = recyclingId;
    }

    /**
     * @return Recycling_max_cy
     */
    public String getRecyclingMaxCy() {
        return recyclingMaxCy;
    }

    /**
     * @param recyclingMaxCy
     */
    public void setRecyclingMaxCy(String recyclingMaxCy) {
        this.recyclingMaxCy = recyclingMaxCy;
    }

    /**
     * @return Recycling_surplus_cy
     */
    public String getRecyclingSurplusCy() {
        return recyclingSurplusCy;
    }

    /**
     * @param recyclingSurplusCy
     */
    public void setRecyclingSurplusCy(String recyclingSurplusCy) {
        this.recyclingSurplusCy = recyclingSurplusCy;
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