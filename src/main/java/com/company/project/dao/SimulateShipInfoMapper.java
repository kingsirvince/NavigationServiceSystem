package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.SimulateShipInfo;
import com.company.project.model.other.SimulateShipInfoIdLongLat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SimulateShipInfoMapper extends Mapper<SimulateShipInfo> {
    Integer simulateCH02601(@Param("mmsi")Integer mmsi,@Param("idPoint")Integer idPoint);
//    Integer updateCH02601(@Param("divisor")Integer divisor,@Param("remainder")Integer remainder,@Param("subtract")Integer subtract);
    List<SimulateShipInfoIdLongLat> getIdLongLat();

    List<Double> getLong();

    List<Double> getLat();
}