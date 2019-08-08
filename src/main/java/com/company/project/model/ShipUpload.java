package com.company.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "ship_upload")
public class ShipUpload {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Ship_MMSI")
    private Integer shipMmsi;

    @Column(name = "Ship_call")
    private String shipCall;

    @Column(name = "Ship_class")
    private String shipClass;

    @Column(name = "Ship_state")
    private String shipState;

    @Column(name = "Ship_longitude")
    private BigDecimal shipLongitude;

    @Column(name = "Ship_latitude")
    private BigDecimal shipLatitude;

    @Column(name = "Ship_length")
    private String shipLength;

    @Column(name = "Ship_width")
    private String shipWidth;

    @Column(name = "Ship_heading")
    private String shipHeading;

    @Column(name = "Ship_speed")
    private String shipSpeed;

    @Column(name = "Ship_draught")
    private String shipDraught;

    @Column(name = "Ship_load")
    private String shipLoad;

    @Column(name = "Datetime")
    private Date datetime;

    @Column(name = "Channel_division_ID")
    private String channelDivisionId;

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
     * @return Ship_MMSI
     */
    public Integer getShipMmsi() {
        return shipMmsi;
    }

    /**
     * @param shipMmsi
     */
    public void setShipMmsi(Integer shipMmsi) {
        this.shipMmsi = shipMmsi;
    }

    /**
     * @return Ship_call
     */
    public String getShipCall() {
        return shipCall;
    }

    /**
     * @param shipCall
     */
    public void setShipCall(String shipCall) {
        this.shipCall = shipCall;
    }

    /**
     * @return Ship_class
     */
    public String getShipClass() {
        return shipClass;
    }

    /**
     * @param shipClass
     */
    public void setShipClass(String shipClass) {
        this.shipClass = shipClass;
    }

    /**
     * @return Ship_state
     */
    public String getShipState() {
        return shipState;
    }

    /**
     * @param shipState
     */
    public void setShipState(String shipState) {
        this.shipState = shipState;
    }

    /**
     * @return Ship_longitude
     */
    public BigDecimal getShipLongitude() {
        return shipLongitude;
    }

    /**
     * @param shipLongitude
     */
    public void setShipLongitude(BigDecimal shipLongitude) {
        this.shipLongitude = shipLongitude;
    }

    /**
     * @return Ship_latitude
     */
    public BigDecimal getShipLatitude() {
        return shipLatitude;
    }

    /**
     * @param shipLatitude
     */
    public void setShipLatitude(BigDecimal shipLatitude) {
        this.shipLatitude = shipLatitude;
    }

    /**
     * @return Ship_length
     */
    public String getShipLength() {
        return shipLength;
    }

    /**
     * @param shipLength
     */
    public void setShipLength(String shipLength) {
        this.shipLength = shipLength;
    }

    /**
     * @return Ship_width
     */
    public String getShipWidth() {
        return shipWidth;
    }

    /**
     * @param shipWidth
     */
    public void setShipWidth(String shipWidth) {
        this.shipWidth = shipWidth;
    }

    /**
     * @return Ship_heading
     */
    public String getShipHeading() {
        return shipHeading;
    }

    /**
     * @param shipHeading
     */
    public void setShipHeading(String shipHeading) {
        this.shipHeading = shipHeading;
    }

    /**
     * @return Ship_speed
     */
    public String getShipSpeed() {
        return shipSpeed;
    }

    /**
     * @param shipSpeed
     */
    public void setShipSpeed(String shipSpeed) {
        this.shipSpeed = shipSpeed;
    }

    /**
     * @return Ship_draught
     */
    public String getShipDraught() {
        return shipDraught;
    }

    /**
     * @param shipDraught
     */
    public void setShipDraught(String shipDraught) {
        this.shipDraught = shipDraught;
    }

    /**
     * @return Ship_load
     */
    public String getShipLoad() {
        return shipLoad;
    }

    /**
     * @param shipLoad
     */
    public void setShipLoad(String shipLoad) {
        this.shipLoad = shipLoad;
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

    /**
     * @return Channel_division_ID
     */
    public String getChannelDivisionId() {
        return channelDivisionId;
    }

    /**
     * @param channelDivisionId
     */
    public void setChannelDivisionId(String channelDivisionId) {
        this.channelDivisionId = channelDivisionId;
    }
}