package com.company.project.service.impl;

import com.company.project.dao.ShipInfoStaticMapper;
import com.company.project.model.ShipInfoStatic;
import com.company.project.service.ShipInfoStaticService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/09/06.
 */
@Service
@Transactional
public class ShipInfoStaticServiceImpl extends AbstractService<ShipInfoStatic> implements ShipInfoStaticService {
    @Resource
    private ShipInfoStaticMapper shipInfoStaticMapper;

    @Override
    public Integer updateToShipInfoStatic() {
        return shipInfoStaticMapper.updateToShipInfoStatic();
    }
}
