package com.company.project.service;

import com.company.project.core.Service;
import com.company.project.model.DataWeather;

import java.util.List;


/**
 * Created by CodeGenerator on 2019/09/18.
 */
public interface DataWeatherService extends Service<DataWeather> {

    List<DataWeather> selectLatestWeather();

    List<DataWeather> selectByCity( String cityname);

}
