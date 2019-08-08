package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.ShipUpload;
import org.springframework.stereotype.Component;

@Component
public interface ShipUploadMapper extends Mapper<ShipUpload> {


    String getChannelDivisionID(Integer MMSI);
}