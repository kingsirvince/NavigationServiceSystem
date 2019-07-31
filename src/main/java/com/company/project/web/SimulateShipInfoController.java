package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.SimulateShipInfo;
import com.company.project.service.SimulateShipInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/07/26.
*/
@RestController
@RequestMapping("/simulate/ship/info")
public class SimulateShipInfoController {
    @Resource
    private SimulateShipInfoService simulateShipInfoService;

    @PostMapping("/add")
    public Result add(SimulateShipInfo simulateShipInfo) {
        simulateShipInfoService.save(simulateShipInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        simulateShipInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(SimulateShipInfo simulateShipInfo) {
        simulateShipInfoService.update(simulateShipInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        SimulateShipInfo simulateShipInfo = simulateShipInfoService.findById(id);
        return ResultGenerator.genSuccessResult(simulateShipInfo);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SimulateShipInfo> list = simulateShipInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
