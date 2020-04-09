package com.company.project.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.util.Date;

@Table(name = "data_weather")
public class DataWeather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cityname;

    @Column(name = "stateDetailed")
    private String statedetailed;

    private String tem1;

    private String tem2;

    @Column(name = "temNow")
    private String temnow;

    @Column(name = "windState")
    private String windstate;

    @Column(name = "windDir")
    private String winddir;

    @Column(name = "windPower")
    private String windpower;

    private String humidity;

    private String time;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
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
     * @return cityname
     */
    public String getCityname() {
        return cityname;
    }

    /**
     * @param cityname
     */
    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    /**
     * @return stateDetailed
     */
    public String getStatedetailed() {
        return statedetailed;
    }

    /**
     * @param statedetailed
     */
    public void setStatedetailed(String statedetailed) {
        this.statedetailed = statedetailed;
    }

    /**
     * @return tem1
     */
    public String getTem1() {
        return tem1;
    }

    /**
     * @param tem1
     */
    public void setTem1(String tem1) {
        this.tem1 = tem1;
    }

    /**
     * @return tem2
     */
    public String getTem2() {
        return tem2;
    }

    /**
     * @param tem2
     */
    public void setTem2(String tem2) {
        this.tem2 = tem2;
    }

    /**
     * @return temNow
     */
    public String getTemnow() {
        return temnow;
    }

    /**
     * @param temnow
     */
    public void setTemnow(String temnow) {
        this.temnow = temnow;
    }

    /**
     * @return windState
     */
    public String getWindstate() {
        return windstate;
    }

    /**
     * @param windstate
     */
    public void setWindstate(String windstate) {
        this.windstate = windstate;
    }

    /**
     * @return windDir
     */
    public String getWinddir() {
        return winddir;
    }

    /**
     * @param winddir
     */
    public void setWinddir(String winddir) {
        this.winddir = winddir;
    }

    /**
     * @return windPower
     */
    public String getWindpower() {
        return windpower;
    }

    /**
     * @param windpower
     */
    public void setWindpower(String windpower) {
        this.windpower = windpower;
    }

    /**
     * @return humidity
     */
    public String getHumidity() {
        return humidity;
    }

    /**
     * @param humidity
     */
    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    /**
     * @return time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time
     */
    public void setTime(String time) {
        this.time = time;
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