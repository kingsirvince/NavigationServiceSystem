package com.company.project.service;

import com.company.project.core.Service;
import com.company.project.model.SimulateShipInfo;
import com.company.project.model.other.SimulateShipInfoIdLongLat;

import java.util.List;


/**
 * Created by CodeGenerator on 2019/07/26.
 */
public interface SimulateShipInfoService extends Service<SimulateShipInfo> {
    Integer simulateCH02601(Integer mmsi,Integer idPoint);
    List<SimulateShipInfoIdLongLat> getIdLongLat();

    List<Double> getLong();
    List<Double> getLat();

//    Integer updateCH02601(Integer divisor, Integer remainder,Integer subtract);

}
