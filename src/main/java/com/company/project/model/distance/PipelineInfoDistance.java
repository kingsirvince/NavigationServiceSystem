package com.company.project.model.distance;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "pipeline_info")
public class PipelineInfoDistance {
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

    @Column(name = "Pipeline_name")
    private String pipelineName;

    @Column(name = "Pipeline_ID")
    private String pipelineId;

    @Column(name = "Pipeline_longitude_A")
    private BigDecimal pipelineLongitudeA;

    @Column(name = "Pipeline_latitude_A")
    private BigDecimal pipelineLatitudeA;

    @Column(name = "Pipeline_longitude_B")
    private BigDecimal pipelineLongitudeB;

    @Column(name = "Pipeline_latitude_B")
    private BigDecimal pipelineLatitudeB;

    @Column(name = "Pipeline_max_limit_height")
    private String pipelineMaxLimitHeight;

    @Column(name = "Pipeline_limit_height")
    private String pipelineLimitHeight;

    @Column(name = "Pipeline_limit_width")
    private String pipelineLimitWidth;
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
     * @return Pipeline_name
     */
    public String getPipelineName() {
        return pipelineName;
    }

    /**
     * @param pipelineName
     */
    public void setPipelineName(String pipelineName) {
        this.pipelineName = pipelineName;
    }

    /**
     * @return Pipeline_ID
     */
    public String getPipelineId() {
        return pipelineId;
    }

    /**
     * @param pipelineId
     */
    public void setPipelineId(String pipelineId) {
        this.pipelineId = pipelineId;
    }

    /**
     * @return Pipeline_longitude_A
     */
    public BigDecimal getPipelineLongitudeA() {
        return pipelineLongitudeA;
    }

    /**
     * @param pipelineLongitudeA
     */
    public void setPipelineLongitudeA(BigDecimal pipelineLongitudeA) {
        this.pipelineLongitudeA = pipelineLongitudeA;
    }

    /**
     * @return Pipeline_latitude_A
     */
    public BigDecimal getPipelineLatitudeA() {
        return pipelineLatitudeA;
    }

    /**
     * @param pipelineLatitudeA
     */
    public void setPipelineLatitudeA(BigDecimal pipelineLatitudeA) {
        this.pipelineLatitudeA = pipelineLatitudeA;
    }

    /**
     * @return Pipeline_longitude_B
     */
    public BigDecimal getPipelineLongitudeB() {
        return pipelineLongitudeB;
    }

    /**
     * @param pipelineLongitudeB
     */
    public void setPipelineLongitudeB(BigDecimal pipelineLongitudeB) {
        this.pipelineLongitudeB = pipelineLongitudeB;
    }

    /**
     * @return Pipeline_latitude_B
     */
    public BigDecimal getPipelineLatitudeB() {
        return pipelineLatitudeB;
    }

    /**
     * @param pipelineLatitudeB
     */
    public void setPipelineLatitudeB(BigDecimal pipelineLatitudeB) {
        this.pipelineLatitudeB = pipelineLatitudeB;
    }

    /**
     * @return Pipeline_max_limit_height
     */
    public String getPipelineMaxLimitHeight() {
        return pipelineMaxLimitHeight;
    }

    /**
     * @param pipelineMaxLimitHeight
     */
    public void setPipelineMaxLimitHeight(String pipelineMaxLimitHeight) {
        this.pipelineMaxLimitHeight = pipelineMaxLimitHeight;
    }

    /**
     * @return Pipeline_limit_height
     */
    public String getPipelineLimitHeight() {
        return pipelineLimitHeight;
    }

    /**
     * @param pipelineLimitHeight
     */
    public void setPipelineLimitHeight(String pipelineLimitHeight) {
        this.pipelineLimitHeight = pipelineLimitHeight;
    }

    /**
     * @return Pipeline_limit_width
     */
    public String getPipelineLimitWidth() {
        return pipelineLimitWidth;
    }

    /**
     * @param pipelineLimitWidth
     */
    public void setPipelineLimitWidth(String pipelineLimitWidth) {
        this.pipelineLimitWidth = pipelineLimitWidth;
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