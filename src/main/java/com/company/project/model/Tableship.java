package com.company.project.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Tableship {
    @Id
    private Integer uuid;

    private String mmsi;

    @Column(name = "Channel_division_ID")
    private String channelDivisionId;

    private String longitude;

    private String latitude;

    private Date datetime;

    private String heading;

    private String speed;

    private String shipclass;

    private String state;

    private String draught;

    private String length;

    private String width;

    private String callsign;

    /**
     * @return uuid
     */
    public Integer getUuid() {
        return uuid;
    }

    /**
     * @param uuid
     */
    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    /**
     * @return mmsi
     */
    public String getMmsi() {
        return mmsi;
    }

    /**
     * @param mmsi
     */
    public void setMmsi(String mmsi) {
        this.mmsi = mmsi;
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

    /**
     * @return longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * @return latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
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

    /**
     * @return heading
     */
    public String getHeading() {
        return heading;
    }

    /**
     * @param heading
     */
    public void setHeading(String heading) {
        this.heading = heading;
    }

    /**
     * @return speed
     */
    public String getSpeed() {
        return speed;
    }

    /**
     * @param speed
     */
    public void setSpeed(String speed) {
        this.speed = speed;
    }

    /**
     * @return shipclass
     */
    public String getShipclass() {
        return shipclass;
    }

    /**
     * @param shipclass
     */
    public void setShipclass(String shipclass) {
        this.shipclass = shipclass;
    }

    /**
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return draught
     */
    public String getDraught() {
        return draught;
    }

    /**
     * @param draught
     */
    public void setDraught(String draught) {
        this.draught = draught;
    }

    /**
     * @return length
     */
    public String getLength() {
        return length;
    }

    /**
     * @param length
     */
    public void setLength(String length) {
        this.length = length;
    }

    /**
     * @return width
     */
    public String getWidth() {
        return width;
    }

    /**
     * @param width
     */
    public void setWidth(String width) {
        this.width = width;
    }

    /**
     * @return callsign
     */
    public String getCallsign() {
        return callsign;
    }

    /**
     * @param callsign
     */
    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }
}