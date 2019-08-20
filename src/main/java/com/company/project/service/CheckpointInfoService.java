package com.company.project.service;

import com.company.project.core.Service;
import com.company.project.model.CheckpointInfo;
import com.company.project.model.distance.CheckpointInfoDistance;

import java.math.BigDecimal;
import java.util.List;


/**
 * Created by CodeGenerator on 2019/08/12.
 */
public interface CheckpointInfoService extends Service<CheckpointInfo> {
    List<CheckpointInfoDistance> sortByDistance(BigDecimal longitude, BigDecimal Latitude, Integer num);
}
