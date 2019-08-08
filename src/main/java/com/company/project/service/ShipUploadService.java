package com.company.project.service;
import com.company.project.model.ShipUpload;
import com.company.project.core.Service;


/**
 * Created by CodeGenerator on 2019/08/07.
 */
public interface ShipUploadService extends Service<ShipUpload> {

    String getChannelDivisionID(Integer MMSI);
}
