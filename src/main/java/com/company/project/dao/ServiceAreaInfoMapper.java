package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.ServiceAreaInfo;
import com.company.project.model.distance.ServiceAreaInfoDistance;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ServiceAreaInfoMapper extends Mapper<ServiceAreaInfo> {
    Integer updateServiceAreaInfoBetweenId(@Param("id1")Integer id1, @Param("id2")Integer id2);
    List<ServiceAreaInfo> singleQuery(@Param("fieldName")String fieldName, @Param("value")String value,@Param("fieldName1")String fieldName1);

    List<ServiceAreaInfoDistance> sortByDistance(@Param("long") BigDecimal longitude, @Param("lat") BigDecimal latitude, @Param("num") Integer num);

}