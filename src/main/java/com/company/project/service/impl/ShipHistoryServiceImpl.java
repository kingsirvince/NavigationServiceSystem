package com.company.project.service.impl;

import com.company.project.dao.ShipHistoryMapper;
import com.company.project.model.ShipHistory;
import com.company.project.service.ShipHistoryService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/08/14.
 */
@Service
@Transactional
public class ShipHistoryServiceImpl extends AbstractService<ShipHistory> implements ShipHistoryService {
    @Resource
    private ShipHistoryMapper shipHistoryMapper;

}
