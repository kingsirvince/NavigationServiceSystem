package com.company.project.model.other;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "simulate_ship_info")
public class SimulateShipInfoIdLongLat {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Ship_longitude")
    private BigDecimal shipLongitude;

    @Column(name = "Ship_latitude")
    private BigDecimal shipLatitude;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getShipLongitude() {
        return shipLongitude;
    }

    public void setShipLongitude(BigDecimal shipLongitude) {
        this.shipLongitude = shipLongitude;
    }

    public BigDecimal getShipLatitude() {
        return shipLatitude;
    }

    public void setShipLatitude(BigDecimal shipLatitude) {
        this.shipLatitude = shipLatitude;
    }
}