package com.company.project.service;
import com.company.project.model.ShipInfo;
import com.company.project.core.Service;


/**
 * Created by CodeGenerator on 2019/07/26.
 */
public interface ShipInfoService extends Service<ShipInfo> {

    Integer updateShipInfoBetweenId(Integer id1,Integer id2);
}
