package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.MaintenanceInfo;
import com.company.project.model.distance.MaintenanceInfoDistance;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface MaintenanceInfoMapper extends Mapper<MaintenanceInfo> {

    List<MaintenanceInfoDistance> sortByDistance(@Param("long") BigDecimal longitude, @Param("lat") BigDecimal latitude, @Param("num") Integer num);

}