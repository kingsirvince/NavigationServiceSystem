package com.company.project.service.impl;

import com.company.project.dao.WaterDepthInfoMapper;
import com.company.project.model.WaterDepthInfo;
import com.company.project.service.WaterDepthInfoService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/08/22.
 */
@Service
@Transactional
public class WaterDepthInfoServiceImpl extends AbstractService<WaterDepthInfo> implements WaterDepthInfoService {
    @Resource
    private WaterDepthInfoMapper waterDepthInfoMapper;

}
