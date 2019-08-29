package com.company.project.service;

import com.company.project.model.GeneralDynamic;
import com.company.project.model.distance.GeneralDynamicDistance;

import java.math.BigDecimal;
import java.util.List;


/**
 * Created by CodeGenerator on 2019/08/20.
 */
public interface GeneralDynamicService  {
    List<GeneralDynamic> getBerth();
    List<GeneralDynamicDistance> berthSortByDistance( BigDecimal longitude,  BigDecimal latitude,  Integer num);
    List<GeneralDynamic> getCharger();
    List<GeneralDynamicDistance> chargerSortByDistance( BigDecimal longitude,  BigDecimal latitude,  Integer num);
    List<GeneralDynamic> getRecycling();
    List<GeneralDynamicDistance> recyclingSortByDistance( BigDecimal longitude,  BigDecimal latitude,  Integer num);
    List<GeneralDynamic> getGas();
    List<GeneralDynamicDistance> gasSortByDistance( BigDecimal longitude,  BigDecimal latitude,  Integer num);
}
