package com.company.project.service;
import com.company.project.model.MaintenanceInfo;
import com.company.project.core.Service;
import com.company.project.model.distance.MaintenanceInfoDistance;

import java.math.BigDecimal;
import java.util.List;


/**
 * Created by CodeGenerator on 2019/08/12.
 */
public interface MaintenanceInfoService extends Service<MaintenanceInfo> {

    List<MaintenanceInfoDistance> sortByDistance(BigDecimal longitude, BigDecimal latitude, Integer num);
}
