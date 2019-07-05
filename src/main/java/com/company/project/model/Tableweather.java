package com.company.project.model;

import javax.persistence.*;

public class Tableweather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "stateDetailed")
    private String statedetailed;

    @Column(name = "temNow")
    private String temnow;

    private String tem1;

    private String tem2;

    @Column(name = "windState")
    private String windstate;

    @Column(name = "windDir")
    private String winddir;

    @Column(name = "windPower")
    private String windpower;

    private String date;

    private String time;

    private String humidity;

    private String state1;

    private String state2;

    private String cityname;

    private String centername;

    private String pyname;

    private String url;

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
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
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
     * @return state1
     */
    public String getState1() {
        return state1;
    }

    /**
     * @param state1
     */
    public void setState1(String state1) {
        this.state1 = state1;
    }

    /**
     * @return state2
     */
    public String getState2() {
        return state2;
    }

    /**
     * @param state2
     */
    public void setState2(String state2) {
        this.state2 = state2;
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
     * @return centername
     */
    public String getCentername() {
        return centername;
    }

    /**
     * @param centername
     */
    public void setCentername(String centername) {
        this.centername = centername;
    }

    /**
     * @return pyname
     */
    public String getPyname() {
        return pyname;
    }

    /**
     * @param pyname
     */
    public void setPyname(String pyname) {
        this.pyname = pyname;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}