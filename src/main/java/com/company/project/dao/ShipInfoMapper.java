package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.ShipInfo;
import org.apache.ibatis.annotations.Param;

public interface ShipInfoMapper extends Mapper<ShipInfo> {
    Integer updateShipInfoBetweenId(@Param("id1")Integer id1, @Param("id2")Integer id2);

}