package com.company.project.model;

public class Boat {
    int  id;
    double longitude;
    double latitude;
    double speed;
    double angle;

    public Boat(int id, double longitude, double latitude, double speed, double angle) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.speed = speed;
        this.angle = angle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
}
