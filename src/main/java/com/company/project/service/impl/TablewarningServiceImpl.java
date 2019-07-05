package com.company.project.service.impl;

import com.company.project.dao.TablewarningMapper;
import com.company.project.model.Tablewarning;
import com.company.project.service.TablewarningService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/07/04.
 */
@Service
@Transactional
public class TablewarningServiceImpl extends AbstractService<Tablewarning> implements TablewarningService {
    @Resource
    private TablewarningMapper tablewarningMapper;

}
