package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.WaterDepthInfo;
import com.company.project.service.WaterDepthInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/08/22.
*/
@RestController
@RequestMapping("/water/depth/info")
public class WaterDepthInfoController {
    @Resource
    private WaterDepthInfoService waterDepthInfoService;

    @PostMapping("/add")
    public Result add(WaterDepthInfo waterDepthInfo) {
        waterDepthInfoService.save(waterDepthInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        waterDepthInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(WaterDepthInfo waterDepthInfo) {
        waterDepthInfoService.update(waterDepthInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        WaterDepthInfo waterDepthInfo = waterDepthInfoService.findById(id);
        return ResultGenerator.genSuccessResult(waterDepthInfo);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<WaterDepthInfo> list = waterDepthInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
