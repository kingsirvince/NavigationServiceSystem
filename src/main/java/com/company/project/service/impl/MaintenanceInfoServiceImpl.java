package com.company.project.service.impl;

import com.company.project.dao.MaintenanceInfoMapper;
import com.company.project.model.MaintenanceInfo;
import com.company.project.model.distance.MaintenanceInfoDistance;
import com.company.project.service.MaintenanceInfoService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;


/**
 * Created by CodeGenerator on 2019/08/12.
 */
@Service
@Transactional
public class MaintenanceInfoServiceImpl extends AbstractService<MaintenanceInfo> implements MaintenanceInfoService {
    @Resource
    private MaintenanceInfoMapper maintenanceInfoMapper;

    @Override
    public List<MaintenanceInfoDistance> sortByDistance(BigDecimal longitude, BigDecimal latitude, Integer num) {
        return maintenanceInfoMapper.sortByDistance(longitude, latitude, num);
    }
}
