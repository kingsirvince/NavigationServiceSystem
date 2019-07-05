package com.company.project.service.impl;

import com.company.project.dao.TableweatherMapper;
import com.company.project.model.Tableweather;
import com.company.project.service.TableweatherService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/07/03.
 */
@Service
@Transactional
public class TableweatherServiceImpl extends AbstractService<Tableweather> implements TableweatherService {
    @Resource
    private TableweatherMapper tableweatherMapper;

}
