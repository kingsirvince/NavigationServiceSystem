package com.company.project.util;

import com.company.project.dao.ShipUploadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 让其他类能够调用mapper和service的方法
 * https://blog.csdn.net/qq_21454973/article/details/89446823
 */
@Component
public class MapperUtil {
@Autowired
    private ShipUploadMapper shipUploadMapper;
    public static MapperUtil mapperUtil;

    @PostConstruct
    public void init(){
        mapperUtil = this;
        mapperUtil.shipUploadMapper = this.shipUploadMapper;
    }

    public static String getShipUploadCDID(Integer MMSI){
        return mapperUtil.shipUploadMapper.getChannelDivisionID(MMSI);
    }
}
