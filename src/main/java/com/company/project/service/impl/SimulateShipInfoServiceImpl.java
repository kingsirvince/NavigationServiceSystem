package com.company.project.service.impl;

import com.company.project.dao.SimulateShipInfoMapper;
import com.company.project.model.SimulateShipInfo;
import com.company.project.service.SimulateShipInfoService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/07/26.
 */
@Service
@Transactional
public class SimulateShipInfoServiceImpl extends AbstractService<SimulateShipInfo> implements SimulateShipInfoService {
    @Resource
    private SimulateShipInfoMapper simulateShipInfoMapper;

}
