package com.company.project.service.impl;

import com.company.project.core.AbstractService;
import com.company.project.dao.DynamicPortMapper;
import com.company.project.model.DynamicPort;
import com.company.project.service.DynamicPortService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/07/31.
 */
@Service
@Transactional
public class DynamicPortServiceImpl extends AbstractService<DynamicPort> implements DynamicPortService {
    @Resource
    private DynamicPortMapper dynamicPortMapper;

    @Override
    public Integer updateDynamicPortBetweenId(Integer id1, Integer id2) {
        return dynamicPortMapper.updateDynamicPortBetweenId(id1,id2);
    }
}
