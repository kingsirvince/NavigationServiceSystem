package com.company.project.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.util.Date;

@Table(name = "ship_monitor")
public class ShipMonitor {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Type")
    private String type;

    @Column(name = "MonitorLog")
    private String monitorLog;

    @Column(name = "RequestID")
    private String requestId;

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
     * @return Type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return MonitorLog
     */
    public String getMonitorLog() {
        return monitorLog;
    }

    /**
     * @param monitorLog
     */
    public void setMonitorLog(String monitorLog) {
        this.monitorLog = monitorLog;
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

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}