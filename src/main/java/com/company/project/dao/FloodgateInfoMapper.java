package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.FloodgateInfo;
import com.company.project.model.distance.FloodgateInfoDistance;
import com.company.project.model.other.FloodgateInfoHeight;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface FloodgateInfoMapper extends Mapper<FloodgateInfo> {

    List<FloodgateInfoDistance> sortByDistance(@Param("long")BigDecimal longitude, @Param("lat")BigDecimal latitude, @Param("num")Integer num);
    Integer updateLimitHeight(@Param("subtrahend") Double subtrahend);
    Double getByRowField(@Param("field")String field, @Param("row")String row,@Param("rowValue")String rowValue);

    List<FloodgateInfoHeight> getLimitHeight();
}