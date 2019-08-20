package com.company.project.model.distance;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "checkpoint_info")
public class CheckpointInfoDistance {
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

    @Column(name = "Checkpoint_name")
    private String checkpointName;

    @Column(name = "Checkpoint_ID")
    private String checkpointId;

    @Column(name = "Checkpoint_longitude")
    private BigDecimal checkpointLongitude;

    @Column(name = "Checkpoint_latitude")
    private BigDecimal checkpointLatitude;
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
     * @return Checkpoint_name
     */
    public String getCheckpointName() {
        return checkpointName;
    }

    /**
     * @param checkpointName
     */
    public void setCheckpointName(String checkpointName) {
        this.checkpointName = checkpointName;
    }

    /**
     * @return Checkpoint_ID
     */
    public String getCheckpointId() {
        return checkpointId;
    }

    /**
     * @param checkpointId
     */
    public void setCheckpointId(String checkpointId) {
        this.checkpointId = checkpointId;
    }

    /**
     * @return Checkpoint_longitude
     */
    public BigDecimal getCheckpointLongitude() {
        return checkpointLongitude;
    }

    /**
     * @param checkpointLongitude
     */
    public void setCheckpointLongitude(BigDecimal checkpointLongitude) {
        this.checkpointLongitude = checkpointLongitude;
    }

    /**
     * @return Checkpoint_latitude
     */
    public BigDecimal getCheckpointLatitude() {
        return checkpointLatitude;
    }

    /**
     * @param checkpointLatitude
     */
    public void setCheckpointLatitude(BigDecimal checkpointLatitude) {
        this.checkpointLatitude = checkpointLatitude;
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