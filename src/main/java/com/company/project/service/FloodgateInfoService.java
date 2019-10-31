package com.company.project.service;

import com.company.project.core.Service;
import com.company.project.model.FloodgateInfo;
import com.company.project.model.distance.FloodgateInfoDistance;
import com.company.project.model.other.FloodgateInfoHeight;

import java.math.BigDecimal;
import java.util.List;


/**
 * Created by CodeGenerator on 2019/08/12.
 */
public interface FloodgateInfoService extends Service<FloodgateInfo> {
    List<FloodgateInfoDistance> sortByDistance( BigDecimal longitude,BigDecimal latitude,Integer num);
    Integer updateLimitHeight( Double subtrahend);
    Double getByRowField(String field, String row, String rowValue);
    List<FloodgateInfoHeight> getLimitHeight();
}
