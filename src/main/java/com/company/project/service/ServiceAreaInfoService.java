package com.company.project.service;
import com.company.project.model.ServiceAreaInfo;
import com.company.project.core.Service;
import com.company.project.model.distance.ServiceAreaInfoDistance;

import java.math.BigDecimal;
import java.util.List;


/**
 * Created by CodeGenerator on 2019/08/12.
 */
public interface ServiceAreaInfoService extends Service<ServiceAreaInfo> {
    Integer updateServiceAreaInfoBetweenId(Integer id1,Integer id2);
    List<ServiceAreaInfo> singleQuery(String fieldName,String value,String fieldName1);

    List<ServiceAreaInfoDistance> sortByDistance(BigDecimal longitude, BigDecimal latitude, Integer num);
}
