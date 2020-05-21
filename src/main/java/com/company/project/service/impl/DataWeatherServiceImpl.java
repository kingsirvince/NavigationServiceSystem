package com.company.project.service.impl;

import com.company.project.dao.DataWeatherMapper;
import com.company.project.model.DataWeather;
import com.company.project.service.DataWeatherService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2019/09/18.
 */
@Service
@Transactional
public class DataWeatherServiceImpl extends AbstractService<DataWeather> implements DataWeatherService {
    @Resource
    private DataWeatherMapper dataWeatherMapper;

    public DataWeatherServiceImpl() {
        super();
    }

    @Override
    public List<DataWeather> selectLatestWeather() {
        return dataWeatherMapper.selectLatestWeather();
    }

    @Override
    public List<DataWeather> selectByCity(String cityname) {
        return dataWeatherMapper.selectByCity(cityname);
    }
}
