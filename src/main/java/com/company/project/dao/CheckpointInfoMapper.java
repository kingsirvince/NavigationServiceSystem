package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.CheckpointInfo;
import com.company.project.model.distance.CheckpointInfoDistance;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface CheckpointInfoMapper extends Mapper<CheckpointInfo> {

    List<CheckpointInfoDistance> sortByDistance(@Param("long") BigDecimal longitude, @Param("lat")BigDecimal Latitude, @Param("num")Integer num);

}