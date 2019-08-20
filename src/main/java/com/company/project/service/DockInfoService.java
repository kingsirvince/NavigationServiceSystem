package com.company.project.service;

import com.company.project.core.Service;
import com.company.project.model.DockInfo;
import com.company.project.model.distance.DockInfoDistance;

import java.math.BigDecimal;
import java.util.List;


/**
 * Created by CodeGenerator on 2019/08/12.
 */
public interface DockInfoService extends Service<DockInfo> {

    List<DockInfoDistance> sortByDistance(BigDecimal longitude, BigDecimal Latitude,Integer num);
}
