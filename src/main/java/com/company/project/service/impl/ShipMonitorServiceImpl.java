package com.company.project.service.impl;

import com.company.project.core.AbstractService;
import com.company.project.dao.ShipMonitorMapper;
import com.company.project.model.ShipMonitor;
import com.company.project.service.ShipMonitorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2019/11/01.
 */
@Service
@Transactional
public class ShipMonitorServiceImpl extends AbstractService<ShipMonitor> implements ShipMonitorService {
    @Resource
    private ShipMonitorMapper shipMonitorMapper;

    @Override
    public List<ShipMonitor> findSeveralMonitor(int num) {
        return shipMonitorMapper.findSeveralMonitor(num);
    }

    @Override
    public List<ShipMonitor> findSeveralByType(int num, String typeName) {
        return shipMonitorMapper.findSeveralByType(num, typeName);
    }

    @Override
    public List<ShipMonitor> findSeveralByRequestId(int num, String requestId) {
        return shipMonitorMapper.findSeveralByRequestId(num,requestId);
    }
}
