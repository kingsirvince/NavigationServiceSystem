package com.company.project.service;

import com.company.project.core.Service;
import com.company.project.model.ShipInfo;

import java.math.BigDecimal;
import java.util.List;


/**
 * Created by CodeGenerator on 2019/07/26.
 */
public interface ShipInfoService extends Service<ShipInfo> {

//    Integer updateShipInfoBetweenId(Integer id1,Integer id2);
    List<ShipInfo> getVicinity(BigDecimal minlng,
                               BigDecimal maxlng,
                               BigDecimal minlat,
                               BigDecimal maxlat);
    Integer updateToShipInfo();
//    List<ShipInfo> nearbyShip(Integer MMSI);
}
