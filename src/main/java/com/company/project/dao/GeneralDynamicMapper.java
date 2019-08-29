package com.company.project.dao;

import com.company.project.model.GeneralDynamic;
import com.company.project.model.distance.GeneralDynamicDistance;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface GeneralDynamicMapper  {
    List<GeneralDynamic> getBerth();

    List<GeneralDynamicDistance> berthSortByDistance(@Param("long") BigDecimal longitude, @Param("lat") BigDecimal latitude, @Param("num") Integer num);

    List<GeneralDynamic> getCharger();

    List<GeneralDynamicDistance> chargerSortByDistance(@Param("long") BigDecimal longitude, @Param("lat") BigDecimal latitude, @Param("num") Integer num);

    List<GeneralDynamic> getRecycling();

    List<GeneralDynamicDistance> recyclingSortByDistance(@Param("long") BigDecimal longitude, @Param("lat") BigDecimal latitude, @Param("num") Integer num);

    List<GeneralDynamic> getGas();

    List<GeneralDynamicDistance> gasSortByDistance(@Param("long") BigDecimal longitude, @Param("lat") BigDecimal latitude, @Param("num") Integer num);
}