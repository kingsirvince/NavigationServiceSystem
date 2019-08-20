package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.PipelineInfo;
import com.company.project.model.distance.PipelineInfoDistance;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface PipelineInfoMapper extends Mapper<PipelineInfo> {

    List<PipelineInfoDistance> sortByDistance(@Param("long") BigDecimal longitude, @Param("lat") BigDecimal latitude, @Param("num") Integer num);
}