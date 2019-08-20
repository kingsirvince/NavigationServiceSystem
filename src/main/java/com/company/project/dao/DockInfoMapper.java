package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.DockInfo;
import com.company.project.model.distance.DockInfoDistance;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface DockInfoMapper extends Mapper<DockInfo> {

    List<DockInfoDistance> sortByDistance(@Param("long") BigDecimal longitude, @Param("lat")BigDecimal Latitude,@Param("num")Integer num);
}