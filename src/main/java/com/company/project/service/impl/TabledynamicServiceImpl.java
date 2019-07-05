package com.company.project.service.impl;

import com.company.project.dao.TabledynamicMapper;
import com.company.project.model.Tabledynamic;
import com.company.project.service.TabledynamicService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/07/05.
 */
@Service
@Transactional
public class TabledynamicServiceImpl extends AbstractService<Tabledynamic> implements TabledynamicService {
    @Resource
    private TabledynamicMapper tabledynamicMapper;

}
