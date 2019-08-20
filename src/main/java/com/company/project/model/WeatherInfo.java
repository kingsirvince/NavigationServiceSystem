package com.company.project.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.util.Date;

@Table(name = "weather_info")
public class WeatherInfo {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Region_ID")
    private String regionId;

    @Column(name = "Weather_today")
    private String weatherToday;

    @Column(name = "Today_temperature_max")
    private Float todayTemperatureMax;

    @Column(name = "Today_temperature_min")
    private Float todayTemperatureMin;

    @Column(name = "Humidity")
    private Integer humidity;

    @Column(name = "Wind_direction")
    private String windDirection;

    @Column(name = "Wind_speed")
    private String windSpeed;

    @Column(name = "Weather_tomorrow")
    private String weatherTomorrow;

    @Column(name = "Tomorrow_temperature_max")
    private Float tomorrowTemperatureMax;

    @Column(name = "Tomorrow_temperature_min")
    private Float tomorrowTemperatureMin;

    @Column(name = "Weather_after")
    private String weatherAfter;

    @Column(name = "After_temperature_max")
    private Float afterTemperatureMax;

    @Column(name = "After_temperature_min")
    private Float afterTemperatureMin;
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
     * @return Region_ID
     */
    public String getRegionId() {
        return regionId;
    }

    /**
     * @param regionId
     */
    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    /**
     * @return Weather_today
     */
    public String getWeatherToday() {
        return weatherToday;
    }

    /**
     * @param weatherToday
     */
    public void setWeatherToday(String weatherToday) {
        this.weatherToday = weatherToday;
    }

    /**
     * @return Today_temperature_max
     */
    public Float getTodayTemperatureMax() {
        return todayTemperatureMax;
    }

    /**
     * @param todayTemperatureMax
     */
    public void setTodayTemperatureMax(Float todayTemperatureMax) {
        this.todayTemperatureMax = todayTemperatureMax;
    }

    /**
     * @return Today_temperature_min
     */
    public Float getTodayTemperatureMin() {
        return todayTemperatureMin;
    }

    /**
     * @param todayTemperatureMin
     */
    public void setTodayTemperatureMin(Float todayTemperatureMin) {
        this.todayTemperatureMin = todayTemperatureMin;
    }

    /**
     * @return Humidity
     */
    public Integer getHumidity() {
        return humidity;
    }

    /**
     * @param humidity
     */
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    /**
     * @return Wind_direction
     */
    public String getWindDirection() {
        return windDirection;
    }

    /**
     * @param windDirection
     */
    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    /**
     * @return Wind_speed
     */
    public String getWindSpeed() {
        return windSpeed;
    }

    /**
     * @param windSpeed
     */
    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    /**
     * @return Weather_tomorrow
     */
    public String getWeatherTomorrow() {
        return weatherTomorrow;
    }

    /**
     * @param weatherTomorrow
     */
    public void setWeatherTomorrow(String weatherTomorrow) {
        this.weatherTomorrow = weatherTomorrow;
    }

    /**
     * @return Tomorrow_temperature_max
     */
    public Float getTomorrowTemperatureMax() {
        return tomorrowTemperatureMax;
    }

    /**
     * @param tomorrowTemperatureMax
     */
    public void setTomorrowTemperatureMax(Float tomorrowTemperatureMax) {
        this.tomorrowTemperatureMax = tomorrowTemperatureMax;
    }

    /**
     * @return Tomorrow_temperature_min
     */
    public Float getTomorrowTemperatureMin() {
        return tomorrowTemperatureMin;
    }

    /**
     * @param tomorrowTemperatureMin
     */
    public void setTomorrowTemperatureMin(Float tomorrowTemperatureMin) {
        this.tomorrowTemperatureMin = tomorrowTemperatureMin;
    }

    /**
     * @return Weather_after
     */
    public String getWeatherAfter() {
        return weatherAfter;
    }

    /**
     * @param weatherAfter
     */
    public void setWeatherAfter(String weatherAfter) {
        this.weatherAfter = weatherAfter;
    }

    /**
     * @return After_temperature_max
     */
    public Float getAfterTemperatureMax() {
        return afterTemperatureMax;
    }

    /**
     * @param afterTemperatureMax
     */
    public void setAfterTemperatureMax(Float afterTemperatureMax) {
        this.afterTemperatureMax = afterTemperatureMax;
    }

    /**
     * @return After_temperature_min
     */
    public Float getAfterTemperatureMin() {
        return afterTemperatureMin;
    }

    /**
     * @param afterTemperatureMin
     */
    public void setAfterTemperatureMin(Float afterTemperatureMin) {
        this.afterTemperatureMin = afterTemperatureMin;
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