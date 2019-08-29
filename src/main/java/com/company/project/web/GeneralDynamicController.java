package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.GeneralDynamic;
import com.company.project.model.distance.GeneralDynamicDistance;
import com.company.project.service.GeneralDynamicService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
* Created by CodeGenerator on 2019/08/20.
*/
@RestController
@RequestMapping("/general/dynamic")
public class GeneralDynamicController {
    @Resource
    private GeneralDynamicService generalDynamicService;

    /**
     * 查询所有锚泊区（集合了服务区和码头Dock的锚泊区）
     * @return
     */
    @PostMapping("/getBerth")
    public Result getBerth() {
        List<GeneralDynamic> list = generalDynamicService.getBerth();
        return ResultGenerator.genSuccessResult(list);
    }

    /**
     * 查询锚泊区，按距离近排序。（集合了服务区和码头dock）
     * @param longitude
     * @param latitude
     * @param num   查询个数，可不填，默认为5
     * @return
     */
    @PostMapping("/berthSortByDistance")
    public Result berthSortByDistance(@RequestParam BigDecimal longitude, @RequestParam BigDecimal latitude, @RequestParam(defaultValue = "5")Integer num) {
        List<GeneralDynamicDistance> list = generalDynamicService.berthSortByDistance(longitude, latitude, num);
        return ResultGenerator.genSuccessResult(list);
    }

    /**
     * 查询所有充电站（从服务区中）
     * @return
     */
    @PostMapping("/getCharger")
    public Result getCharger() {
        List<GeneralDynamic> list=generalDynamicService.getCharger();
        return ResultGenerator.genSuccessResult(list);
    }
    /**
     * 查询充电站，按距离近排序。（从服务区中）
     * @param longitude
     * @param latitude
     * @param num   查询个数，可不填，默认为5
     * @return
     */
    @PostMapping("/chargerSortByDistance")
    public Result chargerSortByDistance(@RequestParam BigDecimal longitude,@RequestParam BigDecimal latitude,@RequestParam(defaultValue = "5")Integer num) {
        List<GeneralDynamicDistance> list = generalDynamicService.chargerSortByDistance(longitude, latitude, num);
        return ResultGenerator.genSuccessResult(list);

    }


    /**
     * 查询所有回收站（从服务区中）
     * @return
     */
    @PostMapping("/getRecycling")
    public Result getRecycling() {
        List<GeneralDynamic> list = generalDynamicService.getRecycling();
        return ResultGenerator.genSuccessResult(list);
    }

    /**
     * 查询回收站，按距离近排序。（从服务区中）
     * @param longitude
     * @param latitude
     * @param num   查询个数，可不填，默认为5
     * @return
     */
    @PostMapping("/recyclingSortByDistance")
    public Result recyclingSortByDistance(@RequestParam BigDecimal longitude, @RequestParam BigDecimal latitude, @RequestParam(defaultValue = "5")Integer num) {
        List<GeneralDynamicDistance> list = generalDynamicService.recyclingSortByDistance(longitude, latitude, num);
        return ResultGenerator.genSuccessResult(list);
    }

    /**
     * 查询所有加油站（从服务区中）
     * @return
     */
    @PostMapping("/getGas")
    public Result getGas() {
        List<GeneralDynamic> list = generalDynamicService.getGas();
        return ResultGenerator.genSuccessResult(list);
    }

    /**
     * 查询加油站，按距离近排序。（从服务区中）
     * @param longitude
     * @param latitude
     * @param num   查询个数，可不填，默认为5
     * @return
     */
    @PostMapping("/gasSortByDistance")
    public Result gasSortByDistance(@RequestParam BigDecimal longitude, @RequestParam BigDecimal latitude, @RequestParam(defaultValue = "5")Integer num) {
        List<GeneralDynamicDistance> list = generalDynamicService.gasSortByDistance(longitude, latitude, num);
        return ResultGenerator.genSuccessResult(list);
    }


/*    @PostMapping("/add")
    public Result add(GeneralDynamic generalDynamic) {
        generalDynamicService.save(generalDynamic);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        generalDynamicService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(GeneralDynamic generalDynamic) {
        generalDynamicService.update(generalDynamic);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        GeneralDynamic generalDynamic = generalDynamicService.findById(id);
        return ResultGenerator.genSuccessResult(generalDynamic);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<GeneralDynamic> list = generalDynamicService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }*/
}
