package com.company.project.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "notice_info")
public class NoticeInfo {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Notice_name")
    private String noticeName;

    @Column(name = "Notice_class")
    private String noticeClass;

    @Column(name = "Notice_longitude")
    private BigDecimal noticeLongitude;

    @Column(name = "Notice_latitude")
    private BigDecimal noticeLatitude;

    @Column(name = "Channel_division_ID")
    private String channelDivisionId;

    @Column(name = "Notice_content")
    private String noticeContent;
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
     * @return Notice_name
     */
    public String getNoticeName() {
        return noticeName;
    }

    /**
     * @param noticeName
     */
    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    /**
     * @return Notice_class
     */
    public String getNoticeClass() {
        return noticeClass;
    }

    /**
     * @param noticeClass
     */
    public void setNoticeClass(String noticeClass) {
        this.noticeClass = noticeClass;
    }

    /**
     * @return Notice_longitude
     */
    public BigDecimal getNoticeLongitude() {
        return noticeLongitude;
    }

    /**
     * @param noticeLongitude
     */
    public void setNoticeLongitude(BigDecimal noticeLongitude) {
        this.noticeLongitude = noticeLongitude;
    }

    /**
     * @return Notice_latitude
     */
    public BigDecimal getNoticeLatitude() {
        return noticeLatitude;
    }

    /**
     * @param noticeLatitude
     */
    public void setNoticeLatitude(BigDecimal noticeLatitude) {
        this.noticeLatitude = noticeLatitude;
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
     * @return Notice_content
     */
    public String getNoticeContent() {
        return noticeContent;
    }

    /**
     * @param noticeContent
     */
    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
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