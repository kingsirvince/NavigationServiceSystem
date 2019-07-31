package com.company.project.service.impl;

import com.company.project.dao.ShipInfoMapper;
import com.company.project.model.ShipInfo;
import com.company.project.service.ShipInfoService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/07/26.
 */
@Service
@Transactional
public class ShipInfoServiceImpl extends AbstractService<ShipInfo> implements ShipInfoService {
    @Resource
    private ShipInfoMapper shipInfoMapper;

    @Override
    public Integer updateShipInfoBetweenId(Integer id1, Integer id2) {
        return shipInfoMapper.updateShipInfoBetweenId(id1,id2);
    }
}
