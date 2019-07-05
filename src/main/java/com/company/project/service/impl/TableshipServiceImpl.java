package com.company.project.service.impl;

import com.company.project.dao.TableshipMapper;
import com.company.project.model.Tableship;
import com.company.project.service.TableshipService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/07/05.
 */
@Service
@Transactional
public class TableshipServiceImpl extends AbstractService<Tableship> implements TableshipService {
    @Resource
    private TableshipMapper tableshipMapper;

}
