package com.company.project.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Tabledynamic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "berth_name")
    private String berthName;

    @Column(name = "berth_ID")
    private String berthId;

    @Column(name = "berth_max_CY")
    private String berthMaxCy;

    @Column(name = "berth_residual_CY")
    private String berthResidualCy;

    @Column(name = "RB_name")
    private String rbName;

    @Column(name = "RB_ID")
    private String rbId;

    @Column(name = "RB_max_CY")
    private String rbMaxCy;

    @Column(name = "RB_residual_CY")
    private String rbResidualCy;

    @Column(name = "charger_name")
    private String chargerName;

    @Column(name = "charger_ID")
    private String chargerId;

    @Column(name = "charger_max_CY")
    private String chargerMaxCy;

    @Column(name = "charger_residual_CY")
    private String chargerResidualCy;

    private Date datetime;

    /**
     * @return id
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
     * @return berth_name
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
     * @return berth_ID
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
     * @return berth_max_CY
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
     * @return berth_residual_CY
     */
    public String getBerthResidualCy() {
        return berthResidualCy;
    }

    /**
     * @param berthResidualCy
     */
    public void setBerthResidualCy(String berthResidualCy) {
        this.berthResidualCy = berthResidualCy;
    }

    /**
     * @return RB_name
     */
    public String getRbName() {
        return rbName;
    }

    /**
     * @param rbName
     */
    public void setRbName(String rbName) {
        this.rbName = rbName;
    }

    /**
     * @return RB_ID
     */
    public String getRbId() {
        return rbId;
    }

    /**
     * @param rbId
     */
    public void setRbId(String rbId) {
        this.rbId = rbId;
    }

    /**
     * @return RB_max_CY
     */
    public String getRbMaxCy() {
        return rbMaxCy;
    }

    /**
     * @param rbMaxCy
     */
    public void setRbMaxCy(String rbMaxCy) {
        this.rbMaxCy = rbMaxCy;
    }

    /**
     * @return RB_residual_CY
     */
    public String getRbResidualCy() {
        return rbResidualCy;
    }

    /**
     * @param rbResidualCy
     */
    public void setRbResidualCy(String rbResidualCy) {
        this.rbResidualCy = rbResidualCy;
    }

    /**
     * @return charger_name
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
     * @return charger_ID
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
     * @return charger_max_CY
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
     * @return charger_residual_CY
     */
    public String getChargerResidualCy() {
        return chargerResidualCy;
    }

    /**
     * @param chargerResidualCy
     */
    public void setChargerResidualCy(String chargerResidualCy) {
        this.chargerResidualCy = chargerResidualCy;
    }

    /**
     * @return datetime
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