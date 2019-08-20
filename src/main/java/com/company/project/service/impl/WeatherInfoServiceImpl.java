package com.company.project.service.impl;

import com.company.project.dao.WeatherInfoMapper;
import com.company.project.model.WeatherInfo;
import com.company.project.service.WeatherInfoService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/08/12.
 */
@Service
@Transactional
public class WeatherInfoServiceImpl extends AbstractService<WeatherInfo> implements WeatherInfoService {
    @Resource
    private WeatherInfoMapper weatherInfoMapper;

}
