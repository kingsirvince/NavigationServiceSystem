package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.DataWeather;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataWeatherMapper extends Mapper<DataWeather> {
    List<DataWeather> selectLatestWeather();

    List<DataWeather> selectByCity(@Param("cityname") String cityname);

}