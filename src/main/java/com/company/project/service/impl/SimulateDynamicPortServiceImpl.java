package com.company.project.service.impl;

import com.company.project.dao.SimulateDynamicPortMapper;
import com.company.project.model.SimulateDynamicPort;
import com.company.project.service.SimulateDynamicPortService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/07/31.
 */
@Service
@Transactional
public class SimulateDynamicPortServiceImpl extends AbstractService<SimulateDynamicPort> implements SimulateDynamicPortService {
    @Resource
    private SimulateDynamicPortMapper simulateDynamicPortMapper;

}
