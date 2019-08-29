package com.company.project.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

public class Test {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String number;

    private Date time;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return time
     */
    public Date getTime() {
        return time;
    }

    /**
     * @param time
     */
    public void setTime(Date time) {
        this.time = time;
    }
}

