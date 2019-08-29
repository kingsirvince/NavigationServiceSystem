package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.BridgeInfo;
import com.company.project.model.distance.BridgeInfoDistance;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface BridgeInfoMapper extends Mapper<BridgeInfo> {
    List<BridgeInfoDistance> sortByDistance(@Param("long") BigDecimal longitude, @Param("lat")BigDecimal Latitude, @Param("num")Integer num);

    Integer updateLimitHeight(@Param("subtrahend") Double subtrahend);

    Double getByRowField(@Param("field")String field, @Param("row")String row,@Param("rowValue")String rowValue);
}