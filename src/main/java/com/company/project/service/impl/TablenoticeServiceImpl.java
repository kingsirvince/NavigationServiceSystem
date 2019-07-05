package com.company.project.service.impl;

import com.company.project.dao.TablenoticeMapper;
import com.company.project.model.Tablenotice;
import com.company.project.service.TablenoticeService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/07/05.
 */
@Service
@Transactional
public class TablenoticeServiceImpl extends AbstractService<Tablenotice> implements TablenoticeService {
    @Resource
    private TablenoticeMapper tablenoticeMapper;

}
