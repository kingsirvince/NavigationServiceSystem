package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.ShipUpload;
import org.apache.poi.hpsf.Decimal;
import org.springframework.stereotype.Component;

@Component
public interface ShipUploadMapper extends Mapper<ShipUpload> {


    String getChannelDivisionID(Integer MMSI);
    Integer updateShipUpload(Integer shipMmsi, String shipCall, String shipClass, String shipState, Decimal shipLongitude,Decimal shipLatitude,String shipLength,String shipWidth,String shipHeading,String shipSpeed,String shipDraught,String shipLoad,String channelDivisionId);

}