package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.ShipMonitor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShipMonitorMapper extends Mapper<ShipMonitor> {
    List<ShipMonitor> findSeveralMonitor(@Param("num") int num);
    List<ShipMonitor> findSeveralByType(@Param("num") int num,@Param("typeName") String typeName);
    List<ShipMonitor> findSeveralByRequestId(@Param("num") int num,@Param("requestId") String requestId);

}