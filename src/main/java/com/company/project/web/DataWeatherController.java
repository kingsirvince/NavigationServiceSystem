package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.DataWeather;
import com.company.project.service.DataWeatherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/09/18.
*/
@RestController
@RequestMapping("/data/weather")
public class DataWeatherController {
    @Resource
    private DataWeatherService dataWeatherService;
//查询由城市名字
    @PostMapping("/findByCity")
    public Result findByCity(@RequestParam String cityName,@RequestParam(defaultValue = "requestId:0") String requestId){
        List<DataWeather> list = dataWeatherService.selectByCity(cityName);

        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/add")
    public Result add(DataWeather dataWeather,@RequestParam(defaultValue = "requestId:0") String requestId) {
        dataWeatherService.save(dataWeather);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id,@RequestParam(defaultValue = "requestId:0") String requestId) {
        dataWeatherService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(DataWeather dataWeather,@RequestParam(defaultValue = "requestId:0") String requestId) {
        dataWeatherService.update(dataWeather);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id,@RequestParam(defaultValue = "requestId:0") String requestId) {
        DataWeather dataWeather = dataWeatherService.findById(id);
        return ResultGenerator.genSuccessResult(dataWeather);
    }

    //查询最近的天气

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,@RequestParam(defaultValue = "requestId:0") String requestId) {
        PageHelper.startPage(page, size);
        List<DataWeather> list = dataWeatherService.selectLatestWeather();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
