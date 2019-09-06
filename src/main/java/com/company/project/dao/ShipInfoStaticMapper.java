package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.ShipInfoStatic;

public interface ShipInfoStaticMapper extends Mapper<ShipInfoStatic> {
    Integer updateToShipInfoStatic();
}