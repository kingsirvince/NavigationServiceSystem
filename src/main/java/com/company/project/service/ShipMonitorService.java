package com.company.project.service;

import com.company.project.core.Service;
import com.company.project.model.ShipMonitor;

import java.util.List;


/**
 * Created by CodeGenerator on 2019/11/01.
 */
public interface ShipMonitorService extends Service<ShipMonitor> {
    List<ShipMonitor> findSeveralMonitor(int num);
    List<ShipMonitor> findSeveralByType( int num, String typeName);
    List<ShipMonitor> findSeveralByRequestId( int num, String requestId);
}
